package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IManagedbugsDAO;

import bean.Buginfo;
import bean.Managedbugs;

/**
 * A data access object (DAO) providing persistence and search support for
 * Managedbugs entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see bean.Managedbugs
 * @author MyEclipse Persistence Tools
 */
public class ManagedbugsDAOImpl extends HibernateDaoSupport implements IManagedbugsDAO{
	private static final Logger log = LoggerFactory
			.getLogger(ManagedbugsDAOImpl.class);
	// property constants
	public static final String USER_INFO_ID = "userInfoId";
	public static final String BUG_INFO_ID = "bugInfoId";

	protected void initDao() {
		// do nothing
	}

	public void save(Managedbugs transientInstance) {
		log.debug("saving Managedbugs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Managedbugs persistentInstance) {
		log.debug("deleting Managedbugs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Managedbugs findById(java.lang.Integer id) {
		log.debug("getting Managedbugs instance with id: " + id);
		try {
			Managedbugs instance = (Managedbugs) getHibernateTemplate().get(
					"bean.Managedbugs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Managedbugs instance) {
		log.debug("finding Managedbugs instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Managedbugs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Managedbugs as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserInfoId(Object userInfoId) {
		return findByProperty(USER_INFO_ID, userInfoId);
	}

	public List findByBugInfoId(Object bugInfoId) {
		return findByProperty(BUG_INFO_ID, bugInfoId);
	}

	public List findAll() {
		log.debug("finding all Managedbugs instances");
		try {
			String queryString = "from Managedbugs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Managedbugs merge(Managedbugs detachedInstance) {
		log.debug("merging Managedbugs instance");
		try {
			Managedbugs result = (Managedbugs) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Managedbugs instance) {
		log.debug("attaching dirty Managedbugs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Managedbugs instance) {
		log.debug("attaching clean Managedbugs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ManagedbugsDAOImpl getFromApplicationContext(
			ApplicationContext ctx) {
		return (ManagedbugsDAOImpl) ctx.getBean("ManagedbugsDAO");
	}
	
	public void update(Managedbugs instance) {
		log.debug("updating Buginfo instance");
		try {
			getHibernateTemplate().update(instance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
}