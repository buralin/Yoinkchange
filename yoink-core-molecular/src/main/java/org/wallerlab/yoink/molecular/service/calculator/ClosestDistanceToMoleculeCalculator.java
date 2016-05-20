/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wallerlab.yoink.molecular.service.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wallerlab.yoink.api.model.molecular.Atom;
import org.wallerlab.yoink.api.model.molecular.Coord;
import org.wallerlab.yoink.api.model.molecular.Molecule;
import org.wallerlab.yoink.api.service.Calculator;
import org.wallerlab.yoink.api.service.math.Vector;
import org.wallerlab.yoink.math.linear.JCudaVector3D;

/**
 * This class is to calculate the closest distance between one point in space and a molecule
 * 
 * @author Min Zheng
 *
 */

@Service
public class ClosestDistanceToMoleculeCalculator implements Calculator<Double, Coord, Molecule> {

	@Resource
	private Calculator<Double, Coord, Atom> distanceCalculator;

	/**
	 * calculate the distance minimum between a coordinate and a molecule.
	 * 
	 * @param gridCoord
	 *            -{@link org.wallerlab.yoink.api.model.molecular.Coord}
	 * @param molecule
	 *            -{@link org.wallerlab.yoink.api.model.molecular.Molecule}
	 * @return density -{@link java.lang.Double}
	 * 
	 */
	public Double calculate(Coord gridCoord, Molecule molecule) {
		List<Double> distances = new ArrayList<Double>();
		Vector coords = new JCudaVector3D();
		double [] d= new double [3*molecule.getAtoms().size()];
			for (int i = 0; i < molecule.getAtoms().size(); i+=3){
			d[i] =  molecule.getAtoms().get(i).getCoordinate().getCoords().getX();
			d[(i+1)] = molecule.getAtoms().get(i).getCoordinate().getCoords().getY();
			d[(i+2)] = molecule.getAtoms().get(i).getCoordinate().getCoords().getZ();
			}
			coords.setInternalVector(d);
			System.out.println("d L�NGE ****** "+ d.length);
		for (Atom atom : molecule.getAtoms()) {
			double tempdistance = distanceCalculator.calculate(gridCoord,
					atom);
			distances.add(tempdistance);
		}
		double distance = Collections.min(distances);
		return distance;
	}
}
