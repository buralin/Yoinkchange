package org.wallerlab.yoink.math.linear;


import org.jblas.DoubleMatrix;
import org.wallerlab.yoink.api.service.math.Vector;

public class JBlasVector3D implements Vector<DoubleMatrix>{
	private DoubleMatrix internalVector;
	private DoubleMatrix tempVector;
	
	public JBlasVector3D (double x, double y, double z){
		this.internalVector = new DoubleMatrix(new double[] {x, y, z});
	}
	public JBlasVector3D (){	
	}
	public JBlasVector3D (double[] d){
		 this.internalVector = new DoubleMatrix(d);
	}
	public DoubleMatrix getInternalVector() {
		return this.internalVector;
	}
	public void setInternalVector(DoubleMatrix internalVector) {
		this.internalVector = internalVector;
	}
	public double dotProduct() {
		return this.internalVector.dot(this.internalVector);
	}
	public double getNorm () {
		return this.internalVector.norm2();
	}
	public Vector add(Vector m) {
		tempVector = this.internalVector.add((DoubleMatrix) m.getInternalVector());
		Vector temp = new JBlasVector3D();
		temp.setInternalVector(tempVector);
		return temp;
	}
	public Vector subtract(Vector m) {
		tempVector = this.internalVector.sub((DoubleMatrix) m.getInternalVector());
		Vector temp = new JBlasVector3D();
		temp.setInternalVector(tempVector);
		return temp;
	}
	public Vector scalarMultiply(double d){
		tempVector = this.internalVector.mul(d);
		Vector temp = new JBlasVector3D();
		temp.setInternalVector(tempVector);
		return temp;
	}
	public double getX() {
		return this.internalVector.get(0,0);
	}
	public double getY() {
		return this.internalVector.get(1,0);
	}
	public double getZ() {
	    return this.internalVector.get(2,0);
    }
	public double distance(Vector m) {
		return this.internalVector.distance2((DoubleMatrix) m.getInternalVector());
	}
	public Vector ebeMultiply(Vector m){
		tempVector = this.internalVector.mul((DoubleMatrix) m.getInternalVector());
		Vector temp = new JBlasVector3D();
		temp.setInternalVector(tempVector);
		return temp;
	}
	public double getEntry(int i) {
		double element = 0;
		switch (i) {
		case 0:
			element = this.internalVector.get(0,0);
			break;
		case 1:
			element = this.internalVector.get(1,0);
			break;
		case 2:
			element = this.internalVector.get(2,0);
			break;
		}
		return element;
	}
	public boolean equals(Vector m) {
		return this.internalVector.equals(m.getInternalVector());
	}
	public double[] toArray() {
		return this.internalVector.toArray();
	}
	public Vector exp(){
		double x = Math.exp(this.internalVector.get(0,0));
		double y = Math.exp(this.internalVector.get(1,0));
		double z = Math.exp(this.internalVector.get(2,0));
		Vector temp = new JBlasVector3D(x,y,z);
		return temp;
	}
}
