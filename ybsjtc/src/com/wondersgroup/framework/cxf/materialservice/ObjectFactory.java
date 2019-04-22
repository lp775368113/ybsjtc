
package com.wondersgroup.framework.cxf.materialservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wondersgroup.framework.cxf.materialservice package. 
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

    private final static QName _GetDWInfo_QNAME = new QName("http://www.inte.material.hcfa.com", "getDWInfo");
    private final static QName _GetDWInfoResponse_QNAME = new QName("http://www.inte.material.hcfa.com", "getDWInfoResponse");
    private final static QName _GetWLInfo_QNAME = new QName("http://www.inte.material.hcfa.com", "getWLInfo");
    private final static QName _GetWLInfoResponse_QNAME = new QName("http://www.inte.material.hcfa.com", "getWLInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wondersgroup.framework.cxf.materialservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDWInfo }
     * 
     */
    public GetDWInfo createGetDWInfo() {
        return new GetDWInfo();
    }

    /**
     * Create an instance of {@link GetDWInfoResponse }
     * 
     */
    public GetDWInfoResponse createGetDWInfoResponse() {
        return new GetDWInfoResponse();
    }

    /**
     * Create an instance of {@link GetWLInfo }
     * 
     */
    public GetWLInfo createGetWLInfo() {
        return new GetWLInfo();
    }

    /**
     * Create an instance of {@link GetWLInfoResponse }
     * 
     */
    public GetWLInfoResponse createGetWLInfoResponse() {
        return new GetWLInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDWInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDWInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.inte.material.hcfa.com", name = "getDWInfo")
    public JAXBElement<GetDWInfo> createGetDWInfo(GetDWInfo value) {
        return new JAXBElement<GetDWInfo>(_GetDWInfo_QNAME, GetDWInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDWInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetDWInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.inte.material.hcfa.com", name = "getDWInfoResponse")
    public JAXBElement<GetDWInfoResponse> createGetDWInfoResponse(GetDWInfoResponse value) {
        return new JAXBElement<GetDWInfoResponse>(_GetDWInfoResponse_QNAME, GetDWInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWLInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetWLInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.inte.material.hcfa.com", name = "getWLInfo")
    public JAXBElement<GetWLInfo> createGetWLInfo(GetWLInfo value) {
        return new JAXBElement<GetWLInfo>(_GetWLInfo_QNAME, GetWLInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWLInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetWLInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.inte.material.hcfa.com", name = "getWLInfoResponse")
    public JAXBElement<GetWLInfoResponse> createGetWLInfoResponse(GetWLInfoResponse value) {
        return new JAXBElement<GetWLInfoResponse>(_GetWLInfoResponse_QNAME, GetWLInfoResponse.class, null, value);
    }

}
