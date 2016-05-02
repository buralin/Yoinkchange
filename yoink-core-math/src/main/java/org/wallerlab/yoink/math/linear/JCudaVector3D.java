package org.wallerlab.yoink.math.linear;

import org.wallerlab.yoink.api.service.math.Vector;

import jcuda.Pointer;
import jcuda.Sizeof;
import jcuda.jcublas.JCublas;



public class JCudaVector3D implements Vector<float []>{
	private float [] internalVector;
	private float [] tempVector; 
	
	public JCudaVector3D (double x, double y, double z){
		this.internalVector = new float [3];
	    internalVector [0] = (float) x;
	    internalVector [1] = (float) y;
	    internalVector [2] = (float) z;
	}
	public JCudaVector3D(){
	}
	public JCudaVector3D (double [] d){
		this.internalVector = new float [d.length];
		for (int i = 0; i < d.length; i++)
		internalVector[i] = (float) d[i];
	}
	public double dotProduct(){
		int n = internalVector.length;
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
	    //Execute dotProduct ACTUNG AUCH FUNKTION DDOT FÜR DOUBLES!!!!!!
		float x = JCublas.cublasSdot(n, deviceinternalVector, 1, deviceinternalVector, 1);
	    //Clean up
	    JCublas.cublasFree(deviceinternalVector);
	    return (double) x;

	}
	public double getNorm(){
		int n = internalVector.length;
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
	    //Execute dotProduct
		float x = JCublas.cublasSnrm2(n, deviceinternalVector, 1);
		//Copy the result from the device to the host
		JCublas.cublasGetVector(n, Sizeof.FLOAT, deviceinternalVector,1 , Pointer.to(internalVector),1);
	    //Clean up
	    JCublas.cublasFree(deviceinternalVector);
	    return (double) x;
	}
	public Vector add(Vector g){
		int n = internalVector.length;
		float alpha = 1.0f;
		float [] m = ((JCudaVector3D) g).toArrayfloat();
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		Pointer deviceinternm = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternm);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(m), 1, deviceinternm, 1);
		//Execute dotProduct
		JCublas.cublasSaxpy(n, alpha, deviceinternalVector, 1, deviceinternm, 1);
		//Copy the result from the device to the host
	    JCublas.cublasGetVector(n, Sizeof.FLOAT, deviceinternm,1 , Pointer.to(m),1);
	    //Clean up
		JCublas.cublasFree(deviceinternalVector);
		JCublas.cublasFree(deviceinternm);
		Vector temp = new JCudaVector3D();
		temp.setInternalVector(m);
		return temp;
	}
	public Vector subtract(Vector m){
		int n = internalVector.length;
		float alpha = -1.0f;
		float [] h = (float[]) m.getInternalVector();
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		Pointer deviceh = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceh);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(h), 1, deviceh, 1);
		//Execute Substract
		JCublas.cublasSaxpy(n, alpha, deviceh, 1, deviceinternalVector, 1);
		//Copy the result from the device to the host
	    JCublas.cublasGetVector(n, Sizeof.FLOAT, deviceinternalVector,1 , Pointer.to(internalVector),1);
	    //Clean up
		JCublas.cublasFree(deviceinternalVector);
		JCublas.cublasFree(deviceh);
		Vector temp = new JCudaVector3D();
		temp.setInternalVector(internalVector);
		return temp;
	}
	public double getX(){
	    return (double) this.internalVector [0];
	}
	public double getY(){
	    return (double) this.internalVector[1];
	}
	public double getZ(){
        return (double) this.internalVector[2];
	}
	public void setInternalVector(float [] internalVector) {
		this.internalVector = internalVector;
	}
	 public double distance(Vector m) {
		 int n = internalVector.length;
		 float alpha = -1.0f;
		 float [] h = (float[]) m.getInternalVector();
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		Pointer deviceh = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceh);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(h), 1, deviceh, 1);
		//Calculate Substract
		JCublas.cublasSaxpy(n, alpha, deviceh, 1, deviceinternalVector, 1);
		//Calculate Norm
		float x = JCublas.cublasSnrm2(n, deviceinternalVector, 1);
		//Clean up
		JCublas.cublasFree(deviceinternalVector);
		JCublas.cublasFree(deviceh);
		return x;
	 }
	 public Vector ebeMultiply(Vector g) {
		int n = internalVector.length;
		float alpha = 1.0f;
		float [] m = ((JCudaVector3D) g).toArrayfloat();
		float [] internalMatrix = new float [n];
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		Pointer deviceinternalMatrix = new Pointer();
		Pointer deviceinternm = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalMatrix);
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternm);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalMatrix), 1, deviceinternalMatrix, 1);
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(m), 1, deviceinternm, 1);
		//Execute dotProduct
		JCublas.cublasSger(n, n, alpha, deviceinternalVector, 1, deviceinternm, 1, deviceinternalMatrix, n);
		//Copy the result from the device to the host
	    JCublas.cublasGetVector(n, Sizeof.FLOAT, deviceinternalMatrix,1 , Pointer.to(internalMatrix),1);
	    //Clean up
	    JCublas.cublasFree(deviceinternalVector);
	    JCublas.cublasFree(deviceinternalMatrix);
	    JCublas.cublasFree(deviceinternm);
		Vector temp = new JCudaVector3D();
		temp.setInternalVector(internalMatrix);
		return temp;
	}
	public double getEntry(int i) {
			double element = 0;
			switch (i) {
			case 0:
				element = (double)this.internalVector[0];
				break;
			case 1:
				element = (double)this.internalVector[1];
				break;
			case 2:
				element = (double)this.internalVector[2];
				break;
			}
			return element;
	}
	public float [] getInternalVector() {
		return this.internalVector;
	}
	public boolean equals(Vector m) {
		return this.internalVector.equals(m.getInternalVector());
	}
	public double[] toArray() {
		double [] array = {this.internalVector[0],this.internalVector[1],this.internalVector[2]};
		return array;
	}
	public float[] toArrayfloat(){
		return this.internalVector;
	}
	public Vector exp() {
		double x = Math.exp(this.internalVector[0]);
		double y = Math.exp(this.internalVector[1]);
		double z = Math.exp(this.internalVector[2]);
		tempVector = new float [3];
		tempVector [0]= (float) x;
		tempVector [1]= (float) y;
		tempVector [2]= (float) z;
		Vector temp = new JCudaVector3D();
		temp.setInternalVector(tempVector);
		return temp;
	}
	public Vector scalarMultiply(double d) {
		float e= (float) d;
		int n = internalVector.length;
		//Initialize JCublas
		JCublas.cublasInit();
		//Allocate memory on the device
		Pointer deviceinternalVector = new Pointer();
		JCublas.cublasAlloc(n, Sizeof.FLOAT,deviceinternalVector);
		//Copy the memory from the host to the device
		JCublas.cublasSetVector(n, Sizeof.FLOAT, Pointer.to(internalVector), 1, deviceinternalVector, 1);
		//Execute dotProduct
		JCublas.cublasSscal(n, e, deviceinternalVector, 1);
		//Copy the result from the device to the host
	    JCublas.cublasGetVector(n, Sizeof.FLOAT, deviceinternalVector,1 , Pointer.to(internalVector),1);
	    //Clean up
		JCublas.cublasFree(deviceinternalVector);
		Vector temp = new JCudaVector3D();
		temp.setInternalVector(internalVector);
		return temp;
	}
}
