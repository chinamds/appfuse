package org.appfuse.dao.hibernate;

import org.appfuse.dao.BaseDaoTestCase;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.mapping.Table;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.imageio.spi.ServiceRegistry;
import javax.persistence.EntityManagerFactory;

/**
 * This class runs a SELECT * of all mapped objects. If an object's
 * corresponding table does not exist in the database, the test will fail.
 */
public class HibernateConfigurationTest extends BaseDaoTestCase {
    @Autowired
    SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Test
    public void testColumnMapping() throws Exception {
        /*Session session = sessionFactory.openSession();
        try {
            Map metadata = sessionFactory.getAllClassMetadata();
            for (Object o : metadata.values()) {
                EntityPersister persister = (EntityPersister) o;
                String className = persister.getEntityName();
                log.debug("Trying select * from: " + className);
                Query q = session.createQuery("from " + className + " c");
                q.iterate();
                log.debug("ok: " + className);
            }
        } finally {
            session.close();
        }*/

    	Session session = sessionFactory.openSession();
    	try {
    		//HibernateUtil util = new HibernateUtil();
    		//HibernateUtil.getSessionFactory();
	    	for(Namespace namespace : EntityMetaData.getMeta()
	    		    .getDatabase()
	    		    .getNamespaces()) {
	    		 
	    		    for( Table table : namespace.getTables()) {
	    		    	log.debug("Table" + table + " has the following columns: " + 
	    		             StreamSupport.stream(
	    		                Spliterators.spliteratorUnknownSize( 
	    		                    table.getColumnIterator(), 
	    		                    Spliterator.ORDERED
	    		                ), 
	    		                false
	    		            )
	    		            .collect( Collectors.toList()) 
	    		        );
	    		    }
	    		}
    	 } finally {
    		 //HibernateUtil.shutdown();
    		 session.close();
         }
    }
}
