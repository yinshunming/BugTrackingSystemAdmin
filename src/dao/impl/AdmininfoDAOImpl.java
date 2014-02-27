package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IAdmininfoDAO;

import bean.Admininfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Admininfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bean.Admininfo
 * @author MyEclipse Persistence Tools
 */
public class AdmininfoDAOImpl extends HibernateDaoSupport implements IAdmininfoDAO{
	private static final Logger log = LoggerFactory
			.getLogger(AdmininfoDAOImpl.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(Admininfo transientInstance) {
		log.debug("saving Admininfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admininfo persistentInstance) {
		log.debug("deleting Admininfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admininfo findById(java.lang.Integer id) {
		log.debug("getting Admininfo instance with id: " + id);
		try {
			Admininfo instance = (Admininfo) getHibernateTemplate().get(
					"bean.Admininfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Admininfo instance) {
		log.debug("finding Admininfo instance by example");
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
		log.debug("finding Admininfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admininfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Admininfo instances");
		try {
			String queryString = "from Admininfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admininfo merge(Admininfo detachedInstance) {
		log.debug("merging Admininfo instance");
		try {
			Admininfo result = (Admininfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admininfo instance) {
		log.debug("attaching dirty Admininfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admininfo instance) {
		log.debug("attaching clean Admininfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdmininfoDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (AdmininfoDAOImpl) ctx.getBean("AdmininfoDAO");
	}
}