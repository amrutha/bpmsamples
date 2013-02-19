package com.soadev.bpmsamples.client;

import com.soadev.mitm.domain.Job;
import com.soadev.mitm.service.HRService;

import commonj.sdo.DataObject;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HRSDOEJBServiceClient {
    public static void main(String [] args) {
        try {
            final Context context = getInitialContext();
            HRService service = (HRService)context.lookup("Model-HRService#com.soadev.mitm.service.HRService");
            DataObject sdo = service.findJobSDOById("AD_PRES");
            System.out.println(sdo.getString("jobTitle"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        // WebLogic Server 10.x connection details
        env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
        env.put(Context.PROVIDER_URL, "t3://localhost:7101");
        return new InitialContext( env );
    }
}
