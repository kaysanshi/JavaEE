
package com.leo.crm.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.leo.crm.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCustomerById_QNAME = new QName("http://service.crm.leo.com/", "getCustomerById");
    private final static QName _AddCustomer_QNAME = new QName("http://service.crm.leo.com/", "addCustomer");
    private final static QName _AddCustomerResponse_QNAME = new QName("http://service.crm.leo.com/", "addCustomerResponse");
    private final static QName _DeleteCustomer_QNAME = new QName("http://service.crm.leo.com/", "deleteCustomer");
    private final static QName _GetPageBean_QNAME = new QName("http://service.crm.leo.com/", "getPageBean");
    private final static QName _GetPageBeanResponse_QNAME = new QName("http://service.crm.leo.com/", "getPageBeanResponse");
    private final static QName _DeleteCustomerResponse_QNAME = new QName("http://service.crm.leo.com/", "deleteCustomerResponse");
    private final static QName _GetCustomerByIdResponse_QNAME = new QName("http://service.crm.leo.com/", "getCustomerByIdResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.leo.crm.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCustomer }
     * 
     */
    public AddCustomer createAddCustomer() {
        return new AddCustomer();
    }

    /**
     * Create an instance of {@link GetCustomerById }
     * 
     */
    public GetCustomerById createGetCustomerById() {
        return new GetCustomerById();
    }

    /**
     * Create an instance of {@link AddCustomerResponse }
     * 
     */
    public AddCustomerResponse createAddCustomerResponse() {
        return new AddCustomerResponse();
    }

    /**
     * Create an instance of {@link GetPageBeanResponse }
     * 
     */
    public GetPageBeanResponse createGetPageBeanResponse() {
        return new GetPageBeanResponse();
    }

    /**
     * Create an instance of {@link GetPageBean }
     * 
     */
    public GetPageBean createGetPageBean() {
        return new GetPageBean();
    }

    /**
     * Create an instance of {@link DeleteCustomer }
     * 
     */
    public DeleteCustomer createDeleteCustomer() {
        return new DeleteCustomer();
    }

    /**
     * Create an instance of {@link DeleteCustomerResponse }
     * 
     */
    public DeleteCustomerResponse createDeleteCustomerResponse() {
        return new DeleteCustomerResponse();
    }

    /**
     * Create an instance of {@link GetCustomerByIdResponse }
     * 
     */
    public GetCustomerByIdResponse createGetCustomerByIdResponse() {
        return new GetCustomerByIdResponse();
    }

    /**
     * Create an instance of {@link DetachedCriteria }
     * 
     */
    public DetachedCriteria createDetachedCriteria() {
        return new DetachedCriteria();
    }

    /**
     * Create an instance of {@link BaseDict }
     * 
     */
    public BaseDict createBaseDict() {
        return new BaseDict();
    }

    /**
     * Create an instance of {@link PageBean }
     * 
     */
    public PageBean createPageBean() {
        return new PageBean();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "getCustomerById")
    public JAXBElement<GetCustomerById> createGetCustomerById(GetCustomerById value) {
        return new JAXBElement<GetCustomerById>(_GetCustomerById_QNAME, GetCustomerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "addCustomer")
    public JAXBElement<AddCustomer> createAddCustomer(AddCustomer value) {
        return new JAXBElement<AddCustomer>(_AddCustomer_QNAME, AddCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "addCustomerResponse")
    public JAXBElement<AddCustomerResponse> createAddCustomerResponse(AddCustomerResponse value) {
        return new JAXBElement<AddCustomerResponse>(_AddCustomerResponse_QNAME, AddCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "deleteCustomer")
    public JAXBElement<DeleteCustomer> createDeleteCustomer(DeleteCustomer value) {
        return new JAXBElement<DeleteCustomer>(_DeleteCustomer_QNAME, DeleteCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPageBean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "getPageBean")
    public JAXBElement<GetPageBean> createGetPageBean(GetPageBean value) {
        return new JAXBElement<GetPageBean>(_GetPageBean_QNAME, GetPageBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPageBeanResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "getPageBeanResponse")
    public JAXBElement<GetPageBeanResponse> createGetPageBeanResponse(GetPageBeanResponse value) {
        return new JAXBElement<GetPageBeanResponse>(_GetPageBeanResponse_QNAME, GetPageBeanResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "deleteCustomerResponse")
    public JAXBElement<DeleteCustomerResponse> createDeleteCustomerResponse(DeleteCustomerResponse value) {
        return new JAXBElement<DeleteCustomerResponse>(_DeleteCustomerResponse_QNAME, DeleteCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.crm.leo.com/", name = "getCustomerByIdResponse")
    public JAXBElement<GetCustomerByIdResponse> createGetCustomerByIdResponse(GetCustomerByIdResponse value) {
        return new JAXBElement<GetCustomerByIdResponse>(_GetCustomerByIdResponse_QNAME, GetCustomerByIdResponse.class, null, value);
    }

}
