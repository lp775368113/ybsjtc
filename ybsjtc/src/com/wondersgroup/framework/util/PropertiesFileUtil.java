package com.wondersgroup.framework.util;

import java.util.*;
import java.io.*;

public class PropertiesFileUtil 
{
    private static PropertiesFileUtil manager = null;
    private static Object managerLock = new Object();
    private String path = getClass().getClassLoader().getResource("").getPath().replaceAll("%20", " ");
    private String resourceURI = path + "/config.properties";
   

    /**
     * Returns a Wonders property.
     *
     * @param name the name of the property to return.
     * @return the property value specified by name.
     */
    public static String getProperty(String name) {
         if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
		    manager = new PropertiesFileUtil();
                }
            }
        }
        return manager.getProp(name);
    }

    public static String getProperty(String name, String defaultvalue) {
       
        return getProperty(name) == null? defaultvalue:getProperty(name);
    }
    /**
     * Sets a Wonders property. If the property doesn't already exists, a new
     * one will be created.
     *
     * @param name the name of the property being set.
     * @param value the value of the property being set.
     */
    public static void setProperty(String name, String value) {
        if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
                    manager = new PropertiesFileUtil();
                }
            }
        }
        manager.setProp(name, value);
    }

    /**
     * Deletes a Wonders property. If the property doesn't exist, the method
     * does nothing.
     *
     * @param name the name of the property to delete.
     */
    public static void deleteProperty(String name) {
        if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
                    manager = new PropertiesFileUtil();
                }
            }
        }
        manager.deleteProp(name);
    }

    /**
     * Returns the names of the application properties.
     *
     * @return an Enumeration of the application property names.
     */
    public static Enumeration propertyNames() {
        if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
                    manager = new PropertiesFileUtil();
                }
            }
        }
        return manager.propNames();
    }

    /**
     * Returns true if the properties are readable. This method is mainly
     * valuable at setup time to ensure that the properties file is setup
     * correctly.
     */
    public static boolean propertyFileIsReadable() {
        if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
                    manager = new PropertiesFileUtil();
                }
            }
        }
        return manager.propFileIsReadable();
    }

    /**
     * Returns true if the properties are writable. This method is mainly
     * valuable at setup time to ensure that the properties file is setup
     * correctly.
     */
    public static boolean propertyFileIsWritable() {
        if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
                    manager = new PropertiesFileUtil();
                }
            }
        }
        return manager.propFileIsWritable();
    }

    /**
     * Returns true if the wonders.properties file exists where the path property
     * purports that it does.
     */
    public static boolean propertyFileExists() {
        if (manager == null) {
            synchronized(managerLock) {
                if (manager == null) {
                    manager = new PropertiesFileUtil();
                }
            }
        }
        return manager.propFileExists();
    }

    private Properties properties = null;
    private Object propertiesLock = new Object();
    //private String resourceURI;

    /**
     * Creates a new PropertiesFileUtils. Singleton access only.
     */
    public PropertiesFileUtil() {
	//this.propsName = resourceURI;
    }

    public PropertiesFileUtil(String resourceURI) {
	this.resourceURI = resourceURI;
    }

    /**
     * Gets a application property. application properties are stored in wonders.properties.
     * The properties file should be accesible from the classpath. Additionally,
     * it should have a path field that gives the full path to where the
     * file is located. Getting properties is a fast operation.
     *
     * @param name the name of the property to get.
     * @return the property specified by name.
     */
    protected String getProp(String name) {
        //If properties aren't loaded yet. We also need to make this thread
        //safe, so synchronize...
        if (properties == null) {
            synchronized(propertiesLock) {
                //Need an additional check
                if (properties == null) {
                    loadProps();
                }
            }
        }
        String property = properties.getProperty(name);
        if (property == null) {
            return null;
        }
        else {
            return property.trim();
        }
    }

    /**
     * Sets a application property. Because the properties must be saved to disk
     * every time a property is set, property setting is relatively slow.
     */
    protected void setProp(String name, String value) {
        //Only one thread should be writing to the file system at once.
        synchronized (propertiesLock) {
            //Create the properties object if necessary.
            if (properties == null) {
                loadProps();
            }
            properties.setProperty(name, value);
            saveProps();
        }
    }

    protected void deleteProp(String name) {
        //Only one thread should be writing to the file system at once.
        synchronized (propertiesLock) {
            //Create the properties object if necessary.
            if (properties == null) {
                loadProps();
            }
            properties.remove(name);
            saveProps();
        }
    }

    protected Enumeration propNames() {
        //If properties aren't loaded yet. We also need to make this thread
        //safe, so synchronize...
        if (properties == null) {
            synchronized(propertiesLock) {
                //Need an additional check
                if (properties == null) {
                    loadProps();
                }
            }
        }
        return properties.propertyNames();
    }

    /**
     * Loads application properties from the disk.
     */
    private void loadProps() {
        properties = new Properties();
        InputStream in = null;
		//System.err.println("resourceURI:"+resourceURI);

        try {
        	//System.out.println(resourceURI);
        	FileInputStream fis = new FileInputStream(resourceURI);
			//in = getClass().getResourceAsStream(resourceURI);
			properties.load(fis);
        }
        catch (Exception e) {
            System.err.println("Error reading application properties in PropertiesFileUtils.loadProps() " + e);
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (Exception e) { }
        }
    }

    /**
     * Saves application properties to disk.
     */
    private void saveProps() {
        //Now, save the properties to disk. In order for this to work, the user
        //needs to have set the path field in the properties file. Trim
        //the String to make sure there are no extra spaces.
        String path = properties.getProperty("path").trim();
	    OutputStream out = null;
        try {
            out = new FileOutputStream(path);
            properties.store(out, "wonders_config.properties -- " + (new java.util.Date()));
        }
        catch (Exception ioe) {
            System.err.println("There was an error writing wonders.properties to " + path + ". " +
                "Ensure that the path exists and that the application process has permission " +
                "to write to it -- " + ioe);
            ioe.printStackTrace();
        }
        finally {
            try {
               out.close();
            } catch (Exception e) { }
        }
    }

    /**
     * Returns true if the properties are readable. This method is mainly
     * valuable at setup time to ensure that the properties file is setup
     * correctly.
     */
    public boolean propFileIsReadable() {
        try {
        	
        	FileInputStream fis = new FileInputStream(resourceURI);
            if(fis!=null)
            	return true;
            else
            	return false;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns true if the wonders.properties file exists where the path property
     * purports that it does.
     */
    public boolean propFileExists() {
        String path = getProp("path");
        File file = new File(path);
        if (file.isFile()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns true if the properties are writable. This method is mainly
     * valuable at setup time to ensure that the properties file is setup
     * correctly.
     */
    public boolean propFileIsWritable() {
        String path = getProp("path");
        File file = new File(path);
        if (file.isFile()) {
            //See if we can write to the file
            if (file.canWrite()) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public static void main(String[] args)
    {
	//PropertiesFileUtils propertyManager = new PropertiesFileUtils();
    	
	String test = PropertiesFileUtil.getProperty("upload.path");
	System.out.println("test" + test);
	
	}

}
