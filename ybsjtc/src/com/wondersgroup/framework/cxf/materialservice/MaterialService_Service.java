package com.wondersgroup.framework.cxf.materialservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.1
 * 2019-04-15T15:33:45.533+08:00
 * Generated source version: 3.3.1
 *
 */
@WebServiceClient(name = "MaterialService",
                  wsdlLocation = "http://localhost:8090/services/MaterialService?wsdl",
                  targetNamespace = "http://www.inte.material.hcfa.com")
public class MaterialService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.inte.material.hcfa.com", "MaterialService");
    public final static QName MaterialServiceImplPort = new QName("http://www.inte.material.hcfa.com", "MaterialServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8090/services/MaterialService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(MaterialService_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:8090/services/MaterialService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public MaterialService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public MaterialService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MaterialService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }





    /**
     *
     * @return
     *     returns MaterialService
     */
    @WebEndpoint(name = "MaterialServiceImplPort")
    public MaterialService getMaterialServiceImplPort() {
        return super.getPort(MaterialServiceImplPort, MaterialService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MaterialService
     */
    @WebEndpoint(name = "MaterialServiceImplPort")
    public MaterialService getMaterialServiceImplPort(WebServiceFeature... features) {
        return super.getPort(MaterialServiceImplPort, MaterialService.class, features);
    }

}
