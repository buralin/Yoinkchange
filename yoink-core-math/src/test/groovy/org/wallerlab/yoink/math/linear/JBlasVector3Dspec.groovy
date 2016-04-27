package org.wallerlab.yoink.math.linear

import org.jblas.DoubleMatrix
import spock.lang.Specification

class JBlasVector3Dspec extends Specification{
	def"internalMatrix is a DoubleMatrix"(){
		when:
		DoubleMatrix internalVector = new DoubleMatrix()
		then:
		assert internalVector.class == DoubleMatrix
	}
	def" create a 3D vector using double array "(){
		double[] d=[0.1, 0.1, 0.1]
		when:
		def jblasVector= new JBlasVector3D(d)
		def vectorFromLibrary = new DoubleMatrix(d)
		then:
		jblasVector.getInternalVector() == vectorFromLibrary
	}
	def"test dot procut"(){
		when:
		def jblasVector= new JBlasVector3D(1,2,2)
		then:
		jblasVector.dotProduct() == 9
	}
	def"test vector norm"(){
		when:
		def jblasVector= new JBlasVector3D(1,2,2);
		then:
		jblasVector.getNorm() == 3
	}
	def "test operator add"(){
		when:
		def v1= new JBlasVector3D(1,1,1);
		def v2= new JBlasVector3D(2,2,2);
		def v = v1.add(v2);
		def v3 = new JBlasVector3D(3,3,3)
		then:
		v.getInternalVector() == v3.getInternalVector()
	}
	def "test operator subtract"(){
		when:
		def v1= new JBlasVector3D(1,1,1);
		def v2= new JBlasVector3D(2,2,2);
		def v = v1.subtract(v2);
		def v3 = new JBlasVector3D(-1,-1,-1)
		then:
		v.getInternalVector() == v3.getInternalVector()
	}
	def "test operator scalarMultiply"(){
		when:
		def v1= new JBlasVector3D(1,1,1)
		def v2= new JBlasVector3D(2,2,2)
		def result = v1.scalarMultiply(2)
		then:
		result.getInternalVector() == v2.getInternalVector()
	}
	def "test element getter methods"(){
		when:
		def v= new JBlasVector3D(1,2,3)
		then:
		v.getX()==1
		v.getY()==2
		v.getZ()==3
	}
	def "test Distance "(){
		when:
	    def v1= new JBlasVector3D(1,1,1)
	    def v2= new JBlasVector3D(1,1,1)
		def result = v1.distance(v2)
		then:
		result == 0
	}
	def "test method ebeMultiply()"(){
		when:
		def v1= new JBlasVector3D (2,2,2);
		def v2=new JBlasVector3D (2,2,2);
		def v=v1.ebeMultiply(v2)
		def result = new JBlasVector3D (4,4,4)
		then:
		v.getInternalVector()== result.getInternalVector()
	}
	def "test method getEntry(int i)"(){
		when:
		def v= new CommonsVector3D(1,2,3);
		then:
		v.getEntry(0) == 1
		v.getEntry(1) == 2
		v.getEntry(2) == 3
	}
	def "test method toArray"() {
		when:
		def v = new JBlasVector3D (1,1,1)
		double[] d=[1, 1, 1]
		double [] g = v.toArray();
		then:
		d == g
	}
	def "test method exp"(){
		when:
		def v = new JBlasVector3D (1,1,1)
		def result = new JBlasVector3D (Math.exp(1),Math.exp(1),Math.exp(1))
		def h = v.exp()
		then:
		h.getInternalVector()== result.getInternalVector()
	}

}
