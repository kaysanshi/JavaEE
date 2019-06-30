
package com.leo.crm.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>customer complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cust_id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cust_industry" type="{http://service.crm.leo.com/}baseDict" minOccurs="0"/>
 *         &lt;element name="cust_level" type="{http://service.crm.leo.com/}baseDict" minOccurs="0"/>
 *         &lt;element name="cust_linkman" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cust_mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cust_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cust_phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cust_source" type="{http://service.crm.leo.com/}baseDict" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "custId",
    "custIndustry",
    "custLevel",
    "custLinkman",
    "custMobile",
    "custName",
    "custPhone",
    "custSource"
})
public class Customer {

    @XmlElement(name = "cust_id")
    protected long custId;
    @XmlElement(name = "cust_industry")
    protected BaseDict custIndustry;
    @XmlElement(name = "cust_level")
    protected BaseDict custLevel;
    @XmlElement(name = "cust_linkman")
    protected String custLinkman;
    @XmlElement(name = "cust_mobile")
    protected String custMobile;
    @XmlElement(name = "cust_name")
    protected String custName;
    @XmlElement(name = "cust_phone")
    protected String custPhone;
    @XmlElement(name = "cust_source")
    protected BaseDict custSource;

    /**
     * 获取custId属性的值。
     * 
     */
    public long getCustId() {
        return custId;
    }

    /**
     * 设置custId属性的值。
     * 
     */
    public void setCustId(long value) {
        this.custId = value;
    }

    /**
     * 获取custIndustry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaseDict }
     *     
     */
    public BaseDict getCustIndustry() {
        return custIndustry;
    }

    /**
     * 设置custIndustry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaseDict }
     *     
     */
    public void setCustIndustry(BaseDict value) {
        this.custIndustry = value;
    }

    /**
     * 获取custLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaseDict }
     *     
     */
    public BaseDict getCustLevel() {
        return custLevel;
    }

    /**
     * 设置custLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaseDict }
     *     
     */
    public void setCustLevel(BaseDict value) {
        this.custLevel = value;
    }

    /**
     * 获取custLinkman属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustLinkman() {
        return custLinkman;
    }

    /**
     * 设置custLinkman属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustLinkman(String value) {
        this.custLinkman = value;
    }

    /**
     * 获取custMobile属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustMobile() {
        return custMobile;
    }

    /**
     * 设置custMobile属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustMobile(String value) {
        this.custMobile = value;
    }

    /**
     * 获取custName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 设置custName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustName(String value) {
        this.custName = value;
    }

    /**
     * 获取custPhone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 设置custPhone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustPhone(String value) {
        this.custPhone = value;
    }

    /**
     * 获取custSource属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaseDict }
     *     
     */
    public BaseDict getCustSource() {
        return custSource;
    }

    /**
     * 设置custSource属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaseDict }
     *     
     */
    public void setCustSource(BaseDict value) {
        this.custSource = value;
    }

}
