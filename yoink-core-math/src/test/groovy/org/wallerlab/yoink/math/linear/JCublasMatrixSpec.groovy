package org.wallerlab.yoink.math.linear

import spock.lang.Specification;

class JCublasMatrixSpec extends Specification{
	def"get row"(){
		when:
		def m = new JCublasMatrix (1,3)
		m.setEntry(0,0,1)
		m.setEntry(0,1,2)
		m.setEntry(0,2,3)
		float [] d = [1,2,3]
		float [] result = m.getRow(0)
		then:
		result == d
	}
	def"convert 2D to 1D"(){
		when:
		def twodim = new JCublasMatrix (2,4)
		float [][] two = [[3, 4, 5, 6], [1, 2, 4, 8]]
		twodim.setInternalMatrix(two)
        def h = twodim.getInternalMatrix()
		def c = twodim.convert2DArrayTo1DArray(h)
		float [] onedim = [3, 4, 5, 6, 1, 2, 4, 8]
		then:
		c == onedim
	}
	def"convert 1D to 2D"(){
		when:
		float [][] two = [[3, 4, 5, 6], [1, 2, 4, 8]]
		def twodim = new JCublasMatrix (2,4)
		float [] one = [3, 4, 5, 6, 1, 2, 4, 8]
		def g = new JCublasMatrix(2,4)
		def c= g.convert1DArrayTo2DArray(one)
		then:
		c == two
	}
	def"change(set/get) the value of a element in matrix"(){
		when:
		def matrix= new JCublasMatrix(1,3)
		then:
		matrix.setEntry(0,0,25)
		matrix.getEntry(0,0)==25
	}
	def "Matrix Add" (){
		when:
		def m = new JCublasMatrix (1,3)
		m.setEntry(0,0,1)
		m.setEntry(0,1,2)
		m.setEntry(0,2,10)
		def h = new JCublasMatrix (1,3)
		h.setEntry(0,0,3)
		h.setEntry(0,1,2)
		h.setEntry(0,2,1)
		def result = m.add(h)
		def c = new JCublasMatrix (1,3)
		c.setEntry(0,0,4)
		c.setEntry(0,1,4)
		c.setEntry(0,2,11)
		then:
		result.getInternalMatrix() == c.getInternalMatrix()
	}
}
