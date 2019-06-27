
package com.wondersgroup.framework.cxf.centerservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wondersgroup.framework.cxf.centerservice package. 
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

    private final static QName _GetBigClasss_QNAME = new QName("http://www.WebService.demo.example.com", "getBigClasss");
    private final static QName _GetBigClasssResponse_QNAME = new QName("http://www.WebService.demo.example.com", "getBigClasssResponse");
    private final static QName _GetMaterielInfo_QNAME = new QName("http://www.WebService.demo.example.com", "getMaterielInfo");
    private final static QName _GetMaterielInfoResponse_QNAME = new QName("http://www.WebService.demo.example.com", "getMaterielInfoResponse");
    private final static QName _GetSmallClasss_QNAME = new QName("http://www.WebService.demo.example.com", "getSmallClasss");
    private final static QName _GetSmallClasssResponse_QNAME = new QName("http://www.WebService.demo.example.com", "getSmallClasssResponse");
    private final static QName _GetSupplier_QNAME = new QName("http://www.WebService.demo.example.com", "getSupplier");
    private final static QName _GetSupplierResponse_QNAME = new QName("http://www.WebService.demo.example.com", "getSupplierResponse");
    private final static QName _InsertBigClasss_QNAME = new QName("http://www.WebService.demo.example.com", "insertBigClasss");
    private final static QName _InsertBigClasssResponse_QNAME = new QName("http://www.WebService.demo.example.com", "insertBigClasssResponse");
    private final static QName _InsertMaterielInfo_QNAME = new QName("http://www.WebService.demo.example.com", "insertMaterielInfo");
    private final static QName _InsertMaterielInfoResponse_QNAME = new QName("http://www.WebService.demo.example.com", "insertMaterielInfoResponse");
    private final static QName _InsertSmallClasss_QNAME = new QName("http://www.WebService.demo.example.com", "insertSmallClasss");
    private final static QName _InsertSmallClasssResponse_QNAME = new QName("http://www.WebService.demo.example.com", "insertSmallClasssResponse");
    private final static QName _InsertSupplier_QNAME = new QName("http://www.WebService.demo.example.com", "insertSupplier");
    private final static QName _InsertSupplierResponse_QNAME = new QName("http://www.WebService.demo.example.com", "insertSupplierResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wondersgroup.framework.cxf.centerservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBigClasss }
     * 
     */
    public GetBigClasss createGetBigClasss() {
        return new GetBigClasss();
    }

    /**
     * Create an instance of {@link GetBigClasssResponse }
     * 
     */
    public GetBigClasssResponse createGetBigClasssResponse() {
        return new GetBigClasssResponse();
    }

    /**
     * Create an instance of {@link GetMaterielInfo }
     * 
     */
    public GetMaterielInfo createGetMaterielInfo() {
        return new GetMaterielInfo();
    }

    /**
     * Create an instance of {@link GetMaterielInfoResponse }
     * 
     */
    public GetMaterielInfoResponse createGetMaterielInfoResponse() {
        return new GetMaterielInfoResponse();
    }

    /**
     * Create an instance of {@link GetSmallClasss }
     * 
     */
    public GetSmallClasss createGetSmallClasss() {
        return new GetSmallClasss();
    }

    /**
     * Create an instance of {@link GetSmallClasssResponse }
     * 
     */
    public GetSmallClasssResponse createGetSmallClasssResponse() {
        return new GetSmallClasssResponse();
    }

    /**
     * Create an instance of {@link GetSupplier }
     * 
     */
    public GetSupplier createGetSupplier() {
        return new GetSupplier();
    }

    /**
     * Create an instance of {@link GetSupplierResponse }
     * 
     */
    public GetSupplierResponse createGetSupplierResponse() {
        return new GetSupplierResponse();
    }

    /**
     * Create an instance of {@link InsertBigClasss }
     * 
     */
    public InsertBigClasss createInsertBigClasss() {
        return new InsertBigClasss();
    }

    /**
     * Create an instance of {@link InsertBigClasssResponse }
     * 
     */
    public InsertBigClasssResponse createInsertBigClasssResponse() {
        return new InsertBigClasssResponse();
    }

    /**
     * Create an instance of {@link InsertMaterielInfo }
     * 
     */
    public InsertMaterielInfo createInsertMaterielInfo() {
        return new InsertMaterielInfo();
    }

    /**
     * Create an instance of {@link InsertMaterielInfoResponse }
     * 
     */
    public InsertMaterielInfoResponse createInsertMaterielInfoResponse() {
        return new InsertMaterielInfoResponse();
    }

    /**
     * Create an instance of {@link InsertSmallClasss }
     * 
     */
    public InsertSmallClasss createInsertSmallClasss() {
        return new InsertSmallClasss();
    }

    /**
     * Create an instance of {@link InsertSmallClasssResponse }
     * 
     */
    public InsertSmallClasssResponse createInsertSmallClasssResponse() {
        return new InsertSmallClasssResponse();
    }

    /**
     * Create an instance of {@link InsertSupplier }
     * 
     */
    public InsertSupplier createInsertSupplier() {
        return new InsertSupplier();
    }

    /**
     * Create an instance of {@link InsertSupplierResponse }
     * 
     */
    public InsertSupplierResponse createInsertSupplierResponse() {
        return new InsertSupplierResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBigClasss }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBigClasss }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getBigClasss")
    public JAXBElement<GetBigClasss> createGetBigClasss(GetBigClasss value) {
        return new JAXBElement<GetBigClasss>(_GetBigClasss_QNAME, GetBigClasss.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBigClasssResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBigClasssResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getBigClasssResponse")
    public JAXBElement<GetBigClasssResponse> createGetBigClasssResponse(GetBigClasssResponse value) {
        return new JAXBElement<GetBigClasssResponse>(_GetBigClasssResponse_QNAME, GetBigClasssResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaterielInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMaterielInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getMaterielInfo")
    public JAXBElement<GetMaterielInfo> createGetMaterielInfo(GetMaterielInfo value) {
        return new JAXBElement<GetMaterielInfo>(_GetMaterielInfo_QNAME, GetMaterielInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaterielInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetMaterielInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getMaterielInfoResponse")
    public JAXBElement<GetMaterielInfoResponse> createGetMaterielInfoResponse(GetMaterielInfoResponse value) {
        return new JAXBElement<GetMaterielInfoResponse>(_GetMaterielInfoResponse_QNAME, GetMaterielInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSmallClasss }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSmallClasss }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getSmallClasss")
    public JAXBElement<GetSmallClasss> createGetSmallClasss(GetSmallClasss value) {
        return new JAXBElement<GetSmallClasss>(_GetSmallClasss_QNAME, GetSmallClasss.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSmallClasssResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSmallClasssResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getSmallClasssResponse")
    public JAXBElement<GetSmallClasssResponse> createGetSmallClasssResponse(GetSmallClasssResponse value) {
        return new JAXBElement<GetSmallClasssResponse>(_GetSmallClasssResponse_QNAME, GetSmallClasssResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupplier }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSupplier }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getSupplier")
    public JAXBElement<GetSupplier> createGetSupplier(GetSupplier value) {
        return new JAXBElement<GetSupplier>(_GetSupplier_QNAME, GetSupplier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSupplierResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetSupplierResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "getSupplierResponse")
    public JAXBElement<GetSupplierResponse> createGetSupplierResponse(GetSupplierResponse value) {
        return new JAXBElement<GetSupplierResponse>(_GetSupplierResponse_QNAME, GetSupplierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertBigClasss }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertBigClasss }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertBigClasss")
    public JAXBElement<InsertBigClasss> createInsertBigClasss(InsertBigClasss value) {
        return new JAXBElement<InsertBigClasss>(_InsertBigClasss_QNAME, InsertBigClasss.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertBigClasssResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertBigClasssResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertBigClasssResponse")
    public JAXBElement<InsertBigClasssResponse> createInsertBigClasssResponse(InsertBigClasssResponse value) {
        return new JAXBElement<InsertBigClasssResponse>(_InsertBigClasssResponse_QNAME, InsertBigClasssResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertMaterielInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertMaterielInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertMaterielInfo")
    public JAXBElement<InsertMaterielInfo> createInsertMaterielInfo(InsertMaterielInfo value) {
        return new JAXBElement<InsertMaterielInfo>(_InsertMaterielInfo_QNAME, InsertMaterielInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertMaterielInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertMaterielInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertMaterielInfoResponse")
    public JAXBElement<InsertMaterielInfoResponse> createInsertMaterielInfoResponse(InsertMaterielInfoResponse value) {
        return new JAXBElement<InsertMaterielInfoResponse>(_InsertMaterielInfoResponse_QNAME, InsertMaterielInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertSmallClasss }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertSmallClasss }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertSmallClasss")
    public JAXBElement<InsertSmallClasss> createInsertSmallClasss(InsertSmallClasss value) {
        return new JAXBElement<InsertSmallClasss>(_InsertSmallClasss_QNAME, InsertSmallClasss.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertSmallClasssResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertSmallClasssResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertSmallClasssResponse")
    public JAXBElement<InsertSmallClasssResponse> createInsertSmallClasssResponse(InsertSmallClasssResponse value) {
        return new JAXBElement<InsertSmallClasssResponse>(_InsertSmallClasssResponse_QNAME, InsertSmallClasssResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertSupplier }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertSupplier }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertSupplier")
    public JAXBElement<InsertSupplier> createInsertSupplier(InsertSupplier value) {
        return new JAXBElement<InsertSupplier>(_InsertSupplier_QNAME, InsertSupplier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertSupplierResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertSupplierResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.WebService.demo.example.com", name = "insertSupplierResponse")
    public JAXBElement<InsertSupplierResponse> createInsertSupplierResponse(InsertSupplierResponse value) {
        return new JAXBElement<InsertSupplierResponse>(_InsertSupplierResponse_QNAME, InsertSupplierResponse.class, null, value);
    }

}
