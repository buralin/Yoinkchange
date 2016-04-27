package org.wallerlab.yoink.math.linear

import org.wallerlab.yoink.api.service.math.Vector.Vector3DType;

import spock.lang.Specification

class JCudaVector3DSpec extends Specification{
	    def "Constructor"(){
			when:
			double [] d = [1,2,3]
			def v = new JCudaVector3D(d);
			then:
			v.getInternalVector() == d
		}
		def "toArray"(){
			when:
			def v = new JCudaVector3D (1,2,3)
			double [] d = [1,2,3]
			then:
		    v.toArray()==d
		}
		def "test dot product"(){
			when:
			def a= new JCudaVector3D(1,2,2)
			def result = a.dotProduct()
			then:
			result==9.0
		}
		def "test vector norm"(){
			when:
			def a= new JCudaVector3D(1,2,2)
			then:
			a.getNorm()==3
		}
		def "test operator scalarMultiply"(){
			when:
			def v1= new JCudaVector3D(1,1,1)
			def v2= new JCudaVector3D(2,2,2)
			def result = v1.scalarMultiply(2.0)
			then:
			result.getInternalVector() == v2.getInternalVector()
			
		}
		def "test element getter methods"(){
			when:
			def v = new JCudaVector3D(1,2,3)
			then:
			v.getX()==1
			v.getY()==2
			v.getZ()==3
		}
		def "test method getEntry(int i)"(){
			when:
			def v= new JCudaVector3D(1,2,3);
			then:
			assert	Math.abs(v.getEntry(0)-1)<=1.0E-6;
			assert	Math.abs(v.getEntry(1)-2)<=1.0E-6;
			assert	Math.abs(v.getEntry(2)-3)<=1.0E-6;
		}
		def "test operator add"(){
			when:
			def m = new JCudaVector3D (2,2,2)
			def h = new JCudaVector3D (1,1,1)
			def k = h.add(m)
			def result = new JCudaVector3D(3,3,3)
			then:
			k.getInternalVector() == result.getInternalVector();
		}
		def "test operator sub"(){
			when:
			def m = new JCudaVector3D (1,2,1)
			def h = new JCudaVector3D (5,7,7)
			def result = new JCudaVector3D(4,5,6)
			def g = h.subtract(m)
			then:
			g.getInternalVector()== result.getInternalVector()
			
		}
		def "test method ebeMultiply()"(){
			when:
			def v1= new JCudaVector3D(2,2,2);
			def v2= new JCudaVector3D(3,3,3);
			def v3=new JCudaVector3D(6,6,6);
			def v=v1.ebeMultiply(v2)
			then:
			v.getInternalVector() == v3.getInternalVector()
		}
		def "test Distance "(){
			when:
			def v1= new JCudaVector3D(4,4,4)
			def v2= new JCudaVector3D(2,2,3)
			def result = v1.distance(v2)
			then:
			assert	Math.abs(3-result)<=1.0E-6;
		}
}
