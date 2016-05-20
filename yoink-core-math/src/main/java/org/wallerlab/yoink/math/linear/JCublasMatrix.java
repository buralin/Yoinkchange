package org.wallerlab.yoink.math.linear;

import jcuda.Pointer;
import jcuda.Sizeof;
import jcuda.jcublas.JCublas;

import org.wallerlab.yoink.api.service.math.Matrix;
/**
 * Vector Adaptor pattern.
 * 
 * thsi class is to convert from our own implementation to the JCublas
 * maths lib.
 * 
 * @author Johannes Tölle
 *
 */
public class JCublasMatrix implements Matrix <float[][]>{
	private float [][] internalMatrix;
	private float [][] tempMatrix;
	
	
	public JCublasMatrix(){

	}
	public JCublasMatrix (int rowDimension, int columnDimension){
		this.internalMatrix = new float [rowDimension][columnDimension];
	}
	public void setEntry (int row, int column, double value){
		this.internalMatrix [row][column]= (float) value;
	}
	public double getEntry(int row, int column){
	    return this.internalMatrix [row][column];
	}
	public Matrix transpose(){
		throw new UnsupportedOperationException();
	}
	public float[] convert2DArrayTo1DArray ( float [][] array ) {
		int totalLength = 0;
		for ( float[] arr : array ) {
			totalLength += arr.length;
		}
		float[] result = new float [ totalLength ];
		int idx = 0;
		for ( float[] arr : array ) {
			for ( float i : arr ) {
				result[ idx++ ] = i;
			}
		}
		return result;
	}
    public float [][] convert1DArrayTo2DArray ( float [] array ) {
	        float [][] array2D = new float [internalMatrix.length][internalMatrix[0].length];
	        int k = 0;
	        for(int i=0;i<internalMatrix.length;i++){
	            for(int j=0;j<internalMatrix[0].length;j++){
					array2D [i][j]= array[k];
	                k++;
	            }
	        }
	        return array2D;
    }
    public Matrix add(Matrix m){
	    float [] internMatrix;
		float alpha = 1.0f;
		internMatrix = convert2DArrayTo1DArray(this.internalMatrix);
		float [] internm = convert2DArrayTo1DArray(((JCublasMatrix) m).getDatafloat());
		int nrow= internalMatrix.length;
		int mcolumn = internalMatrix[0].length;
		int nm = nrow*mcolumn;

		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternMatrix = new Pointer();
		JCublas.cublasAlloc(nm, Sizeof.FLOAT,deviceinternMatrix);
		Pointer deviceinternm = new Pointer();
		JCublas.cublasAlloc(nm, Sizeof.FLOAT,deviceinternm);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(nm, Sizeof.FLOAT, Pointer.to(internMatrix), 1, deviceinternMatrix, 1);
		JCublas.cublasSetVector(nm, Sizeof.FLOAT, Pointer.to(internm), 1, deviceinternm, 1);
		//Execute add
		JCublas.cublasSaxpy(nm, alpha, deviceinternMatrix, 1, deviceinternm, 1);
		//Copy the result from the device to the host
	    JCublas.cublasGetVector(nm, Sizeof.FLOAT, deviceinternm,1 , Pointer.to(internm),1);
	    JCublas.cublasGetVector(nm, Sizeof.FLOAT, deviceinternMatrix,1 , Pointer.to(internMatrix),1);
	    //Clean up
		JCublas.cublasFree(deviceinternMatrix);
		JCublas.cublasFree(deviceinternm);
		Matrix temp = new JCublasMatrix();
		tempMatrix = convert1DArrayTo2DArray(internm);
		temp.setInternalMatrix(tempMatrix);
		return temp;
		}
	@Override
	public void array2DRowRealMatrix(double[][] d) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addToEntry(int row, int column, double increment) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Matrix subtract(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix scalarMultiply(double d) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Matrix ebeMultiply(Matrix m) {
		// TODO Auto-generated method stub
		return null;
	}
	public float[][] getDatafloat() {
		return internalMatrix;
	}
	@Override
	public double[] getRow(int i) {
		double rowarray[] = new double [internalMatrix[0].length]; 
		for (int j = 0; j< internalMatrix[0].length;j++){
		rowarray [j]=  internalMatrix[i][j];
	}
		return rowarray;
	}
	@Override
	public double dotProduct() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double distance(Matrix m) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double getNorm() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean equals(Matrix m) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public float [][] getInternalMatrix() {
		return internalMatrix;
	}
	@Override
	public void setInternalMatrix(float[][] internalMatrix) {
		this.internalMatrix = internalMatrix;
	}
	@Override
	public double[][] getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
