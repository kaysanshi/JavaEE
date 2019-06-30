
package com.leo.crm.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>baseDict complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="baseDict">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dict_enable" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="dict_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dict_item_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dict_item_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dict_memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dict_sort" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dict_type_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dict_type_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseDict", propOrder = {
    "dictEnable",
    "dictId",
    "dictItemCode",
    "dictItemName",
    "dictMemo",
    "dictSort",
    "dictTypeCode",
    "dictTypeName"
})
public class BaseDict {

    @XmlElement(name = "dict_enable")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer dictEnable;
    @XmlElement(name = "dict_id")
    protected String dictId;
    @XmlElement(name = "dict_item_code")
    protected String dictItemCode;
    @XmlElement(name = "dict_item_name")
    protected String dictItemName;
    @XmlElement(name = "dict_memo")
    protected String dictMemo;
    @XmlElement(name = "dict_sort")
    protected int dictSort;
    @XmlElement(name = "dict_type_code")
    protected String dictTypeCode;
    @XmlElement(name = "dict_type_name")
    protected String dictTypeName;

    /**
     * 获取dictEnable属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDictEnable() {
        return dictEnable;
    }

    /**
     * 设置dictEnable属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDictEnable(Integer value) {
        this.dictEnable = value;
    }

    /**
     * 获取dictId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictId() {
        return dictId;
    }

    /**
     * 设置dictId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictId(String value) {
        this.dictId = value;
    }

    /**
     * 获取dictItemCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictItemCode() {
        return dictItemCode;
    }

    /**
     * 设置dictItemCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictItemCode(String value) {
        this.dictItemCode = value;
    }

    /**
     * 获取dictItemName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictItemName() {
        return dictItemName;
    }

    /**
     * 设置dictItemName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictItemName(String value) {
        this.dictItemName = value;
    }

    /**
     * 获取dictMemo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictMemo() {
        return dictMemo;
    }

    /**
     * 设置dictMemo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictMemo(String value) {
        this.dictMemo = value;
    }

    /**
     * 获取dictSort属性的值。
     * 
     */
    public int getDictSort() {
        return dictSort;
    }

    /**
     * 设置dictSort属性的值。
     * 
     */
    public void setDictSort(int value) {
        this.dictSort = value;
    }

    /**
     * 获取dictTypeCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictTypeCode() {
        return dictTypeCode;
    }

    /**
     * 设置dictTypeCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictTypeCode(String value) {
        this.dictTypeCode = value;
    }

    /**
     * 获取dictTypeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDictTypeName() {
        return dictTypeName;
    }

    /**
     * 设置dictTypeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDictTypeName(String value) {
        this.dictTypeName = value;
    }

}
