//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.29 at 10:54:28 PM EST 
//

package org.xml_cml.schema;

import java.util.HashMap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://www.xml-cml.org/schema}anyCml"/>
 *         &lt;any processContents='lax' namespace='##other'/>
 *         &lt;any processContents='lax' namespace=''/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}convention"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}atomRefs2"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}ref"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}dictRef"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}order"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}title"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}id"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}bondRefs"/>
 *       &lt;attGroup ref="{http://www.xml-cml.org/schema}atomRefs"/>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "anyCmlOrAnyOrAny" })
public class Bond {

	@XmlElementRef(name = "anyCml", namespace = "http://www.xml-cml.org/schema", type = JAXBElement.class, required = false)
	@XmlAnyElement(lax = true)
	protected java.util.List<java.lang.Object> anyCmlOrAnyOrAny;
	@XmlAttribute(name = "convention")
	protected String convention;
	@XmlAttribute(name = "atomRefs2")
	protected java.util.List<String> atomRefs2;
	@XmlAttribute(name = "ref")
	protected String ref;
	@XmlAttribute(name = "dictRef")
	protected String dictRef;
	@XmlAttribute(name = "order")
	protected String order;
	@XmlAttribute(name = "title")
	protected String title;
	@XmlAttribute(name = "id")
	protected String id;
	@XmlAttribute(name = "bondRefs")
	protected java.util.List<String> bondRefs;
	@XmlAttribute(name = "atomRefs")
	protected java.util.List<String> atomRefs;
	@XmlAnyAttribute
	private java.util.Map<QName, String> otherAttributes = new HashMap<QName, String>();

	/**
	 * Gets the value of the anyCmlOrAnyOrAny property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the anyCmlOrAnyOrAny property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAnyCmlOrAnyOrAny().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link JAXBElement }{@code <}{@link Line3 }{@code >} {@link JAXBElement }
	 * {@code <}{@link SubstanceList }{@code >} {@link JAXBElement }{@code <}
	 * {@link java.lang.Object }{@code >} {@link JAXBElement }{@code <}
	 * {@link TransitionState }{@code >} {@link JAXBElement }{@code <}
	 * {@link ReactionScheme }{@code >} {@link JAXBElement }{@code <}
	 * {@link MechanismComponent }{@code >} {@link JAXBElement }{@code <}
	 * {@link Yaxis }{@code >} {@link JAXBElement }{@code <}{@link AtomArray }
	 * {@code >} {@link JAXBElement }{@code <}{@link Metadata }{@code >}
	 * {@link JAXBElement }{@code <}{@link Band }{@code >} {@link JAXBElement }
	 * {@code <}{@link ZMatrix }{@code >} {@link JAXBElement }{@code <}
	 * {@link Fragment }{@code >} {@link JAXBElement }{@code <}{@link Reaction }
	 * {@code >} {@link JAXBElement }{@code <}{@link FragmentList }{@code >}
	 * {@link JAXBElement }{@code <}{@link Electron }{@code >} {@link JAXBElement }
	 * {@code <}{@link MoleculeList }{@code >} {@link JAXBElement }{@code <}
	 * {@link Isotope }{@code >} {@link java.lang.Object } {@link JAXBElement }
	 * {@code <}{@link Plane3 }{@code >} {@link JAXBElement }{@code <}
	 * {@link LatticeVector }{@code >} {@link JAXBElement }{@code <}
	 * {@link org.xml_cml.schema.ArrayList }{@code >} {@link JAXBElement }{@code <}
	 * {@link AtomParity }{@code >} {@link Element } {@link JAXBElement }{@code <}
	 * {@link SpectrumData }{@code >} {@link JAXBElement }{@code <}
	 * {@link TableCell }{@code >} {@link JAXBElement }{@code <}{@link Matrix }
	 * {@code >} {@link JAXBElement }{@code <}{@link Gradient }{@code >}
	 * {@link JAXBElement }{@code <}{@link Point3 }{@code >} {@link JAXBElement }
	 * {@code <}{@link org.xml_cml.schema.List }{@code >} {@link JAXBElement }
	 * {@code <}{@link CellParameter }{@code >} {@link JAXBElement }{@code <}
	 * {@link Cml }{@code >} {@link JAXBElement }{@code <}{@link Dimension }
	 * {@code >} {@link JAXBElement }{@code <}{@link PeakGroup }{@code >}
	 * {@link JAXBElement }{@code <}{@link Transform3 }{@code >}
	 * {@link JAXBElement }{@code <}{@link Sample }{@code >} {@link JAXBElement }
	 * {@code <}{@link Scalar }{@code >} {@link JAXBElement }{@code <}
	 * {@link Module }{@code >} {@link JAXBElement }{@code <}{@link Spectator }
	 * {@code >} {@link JAXBElement }{@code <}{@link Unit }{@code >}
	 * {@link JAXBElement }{@code <}{@link Link }{@code >} {@link JAXBElement }
	 * {@code <}{@link Description }{@code >} {@link JAXBElement }{@code <}
	 * {@link BondArray }{@code >} {@link JAXBElement }{@code <}{@link Dictionary }
	 * {@code >} {@link JAXBElement }{@code <}{@link UnitType }{@code >}
	 * {@link JAXBElement }{@code <}{@link Observation }{@code >}
	 * {@link JAXBElement }{@code <}{@link Amount }{@code >} {@link JAXBElement }
	 * {@code <}{@link Join }{@code >} {@link JAXBElement }{@code <}
	 * {@link TableHeader }{@code >} {@link JAXBElement }{@code <}{@link PeakList }
	 * {@code >} {@link JAXBElement }{@code <}{@link PeakStructure }{@code >}
	 * {@link JAXBElement }{@code <}{@link TableRow }{@code >} {@link JAXBElement }
	 * {@code <}{@link Substance }{@code >} {@link JAXBElement }{@code <}
	 * {@link ReactiveCentre }{@code >} {@link JAXBElement }{@code <}{@link Entry }
	 * {@code >} {@link JAXBElement }{@code <}{@link Property }{@code >}
	 * {@link JAXBElement }{@code <}{@link UnitTypeList }{@code >}
	 * {@link JAXBElement }{@code <}{@link BondTypeList }{@code >}
	 * {@link JAXBElement }{@code <}{@link BasisSet }{@code >} {@link JAXBElement }
	 * {@code <}{@link Identifier }{@code >} {@link JAXBElement }{@code <}
	 * {@link BondStereo }{@code >} {@link JAXBElement }{@code <}
	 * {@link KpointList }{@code >} {@link JAXBElement }{@code <}{@link Torsion }
	 * {@code >} {@link JAXBElement }{@code <}{@link Crystal }{@code >}
	 * {@link JAXBElement }{@code <}{@link Atom }{@code >} {@link JAXBElement }
	 * {@code <}{@link Kpoint }{@code >} {@link JAXBElement }{@code <}
	 * {@link Length }{@code >} {@link JAXBElement }{@code <}{@link Particle }
	 * {@code >} {@link JAXBElement }{@code <}{@link Action }{@code >}
	 * {@link JAXBElement }{@code <}{@link Table }{@code >} {@link JAXBElement }
	 * {@code <}{@link Stmml }{@code >} {@link JAXBElement }{@code <}
	 * {@link PropertyList }{@code >} {@link JAXBElement }{@code <}
	 * {@link AtomType }{@code >} {@link JAXBElement }{@code <}{@link UnitList }
	 * {@code >} {@link JAXBElement }{@code <}{@link MetadataList }{@code >}
	 * {@link JAXBElement }{@code <}{@link ReactionStepList }{@code >}
	 * {@link JAXBElement }{@code <}{@link Molecule }{@code >} {@link JAXBElement }
	 * {@code <}{@link IsotopeList }{@code >} {@link JAXBElement }{@code <}
	 * {@link Peak }{@code >} {@link JAXBElement }{@code <}{@link PotentialForm }
	 * {@code >} {@link JAXBElement }{@code <}{@link BandList }{@code >}
	 * {@link JAXBElement }{@code <}{@link TableContent }{@code >}
	 * {@link JAXBElement }{@code <}{@link ProductList }{@code >}
	 * {@link JAXBElement }{@code <}{@link PotentialList }{@code >}
	 * {@link JAXBElement }{@code <}{@link org.xml_cml.schema.Object }{@code >}
	 * {@link JAXBElement }{@code <}{@link ActionList }{@code >}
	 * {@link JAXBElement }{@code <}{@link ReactionList }{@code >}
	 * {@link JAXBElement }{@code <}{@link Spectrum }{@code >} {@link JAXBElement }
	 * {@code <}{@link Eigen }{@code >} {@link JAXBElement }{@code <}
	 * {@link ConditionList }{@code >} {@link JAXBElement }{@code <}
	 * {@link SpectatorList }{@code >} {@link JAXBElement }{@code <}
	 * {@link ParameterList }{@code >} {@link JAXBElement }{@code <}
	 * {@link ReactantList }{@code >} {@link JAXBElement }{@code <}
	 * {@link Reactant }{@code >} {@link JAXBElement }{@code <}{@link BondSet }
	 * {@code >} {@link JAXBElement }{@code <}{@link TableHeaderCell }{@code >}
	 * {@link JAXBElement }{@code <}{@link System }{@code >} {@link JAXBElement }
	 * {@code <}{@link Mechanism }{@code >} {@link JAXBElement }{@code <}
	 * {@link Abundance }{@code >} {@link JAXBElement }{@code <}{@link Bond }
	 * {@code >} {@link JAXBElement }{@code <}{@link Name }{@code >}
	 * {@link JAXBElement }{@code <}{@link Array }{@code >} {@link JAXBElement }
	 * {@code <}{@link Vector3 }{@code >} {@link JAXBElement }{@code <}
	 * {@link AtomicBasisFunction }{@code >} {@link JAXBElement }{@code <}
	 * {@link TableRowList }{@code >} {@link JAXBElement }{@code <}
	 * {@link Parameter }{@code >} {@link JAXBElement }{@code <}{@link Label }
	 * {@code >} {@link JAXBElement }{@code <}{@link AtomTypeList }{@code >}
	 * {@link JAXBElement }{@code <}{@link Product }{@code >} {@link JAXBElement }
	 * {@code <}{@link Sphere3 }{@code >} {@link JAXBElement }{@code <}
	 * {@link ReactionStep }{@code >} {@link JAXBElement }{@code <}{@link Xaxis }
	 * {@code >} {@link JAXBElement }{@code <}{@link Definition }{@code >}
	 * {@link JAXBElement }{@code <}{@link AtomSet }{@code >} {@link JAXBElement }
	 * {@code <}{@link Formula }{@code >} {@link JAXBElement }{@code <}
	 * {@link Angle }{@code >} {@link JAXBElement }{@code <}{@link Lattice }
	 * {@code >} {@link JAXBElement }{@code <}{@link org.xml_cml.schema.Map }
	 * {@code >} {@link JAXBElement }{@code <}{@link Potential }{@code >}
	 * {@link JAXBElement }{@code <}{@link Documentation }{@code >}
	 * {@link JAXBElement }{@code <}{@link Symmetry }{@code >} {@link JAXBElement }
	 * {@code <}{@link SpectrumList }{@code >} {@link JAXBElement }{@code <}
	 * {@link Region }{@code >} {@link JAXBElement }{@code <}{@link BondType }
	 * {@code >}
	 * 
	 * 
	 */
	public java.util.List<java.lang.Object> getAnyCmlOrAnyOrAny() {
		if (anyCmlOrAnyOrAny == null) {
			anyCmlOrAnyOrAny = new java.util.ArrayList<java.lang.Object>();
		}
		return this.anyCmlOrAnyOrAny;
	}

	/**
	 * Gets the value of the convention property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getConvention() {
		return convention;
	}

	/**
	 * Sets the value of the convention property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setConvention(String value) {
		this.convention = value;
	}

	/**
	 * Gets the value of the atomRefs2 property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the atomRefs2 property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAtomRefs2().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public java.util.List<String> getAtomRefs2() {
		if (atomRefs2 == null) {
			atomRefs2 = new java.util.ArrayList<String>();
		}
		return this.atomRefs2;
	}

	/**
	 * Gets the value of the ref property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Sets the value of the ref property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRef(String value) {
		this.ref = value;
	}

	/**
	 * Gets the value of the dictRef property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDictRef() {
		return dictRef;
	}

	/**
	 * Sets the value of the dictRef property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDictRef(String value) {
		this.dictRef = value;
	}

	/**
	 * Gets the value of the order property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * Sets the value of the order property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOrder(String value) {
		this.order = value;
	}

	/**
	 * Gets the value of the title property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the value of the title property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setTitle(String value) {
		this.title = value;
	}

	/**
	 * Gets the value of the id property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the bondRefs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the bondRefs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBondRefs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public java.util.List<String> getBondRefs() {
		if (bondRefs == null) {
			bondRefs = new java.util.ArrayList<String>();
		}
		return this.bondRefs;
	}

	/**
	 * Gets the value of the atomRefs property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the atomRefs property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAtomRefs().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link String }
	 * 
	 * 
	 */
	public java.util.List<String> getAtomRefs() {
		if (atomRefs == null) {
			atomRefs = new java.util.ArrayList<String>();
		}
		return this.atomRefs;
	}

	/**
	 * Gets a map that contains attributes that aren't bound to any typed
	 * property on this class.
	 * 
	 * <p>
	 * the map is keyed by the name of the attribute and the value is the string
	 * value of the attribute.
	 * 
	 * the map returned by this method is live, and you can add new attribute by
	 * updating the map directly. Because of this design, there's no setter.
	 * 
	 * 
	 * @return always non-null
	 */
	public java.util.Map<QName, String> getOtherAttributes() {
		return otherAttributes;
	}

}
