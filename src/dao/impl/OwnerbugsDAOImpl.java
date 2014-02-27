package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IOwnerbugsDAO;

import bean.Ownerbugs;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ownerbugs entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bean.Ownerbugs
 * @author MyEclipse Persistence Tools
 */
public class OwnerbugsDAOImpl extends HibernateDaoSupport implements IOwnerbugsDAO{
	private static final Logger log = LoggerFactory
			.getLogger(OwnerbugsDAOImpl.class);
	// property constants
	public static final String USER_INFO_ID = "userInfoId";
	public static final String BUG_INFO_ID = "bugInfoId";
	public static final String STATUS = "status";
	public static final String CHANGED = "changed";
	public static final String NEW_OWNER = "newOwner";

	protected void initDao() {
		// do nothing
	}

	public void save(Ownerbugs transientInstance) {
		log.debug("saving Ownerbugs instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ownerbugs persistentInstance) {
		log.debug("deleting Ownerbugs instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ownerbugs findById(java.lang.Integer id) {
		log.debug("getting Ownerbugs instance with id: " + id);
		try {
			Ownerbugs instance = (Ownerbugs) getHibernateTemplate().get(
					"bean.Ownerbugs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ownerbugs instance) {
		log.debug("finding Ownerbugs instance by example");
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
		log.debug("finding Ownerbugs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ownerbugs as model where model."
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

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByChanged(Object changed) {
		return findByProperty(CHANGED, changed);
	}

	public List findByNewOwner(Object newOwner) {
		return findByProperty(NEW_OWNER, newOwner);
	}

	public List findAll() {
		log.debug("finding all Ownerbugs instances");
		try {
			String queryString = "from Ownerbugs";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ownerbugs merge(Ownerbugs detachedInstance) {
		log.debug("merging Ownerbugs instance");
		try {
			Ownerbugs result = (Ownerbugs) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ownerbugs instance) {
		log.debug("attaching dirty Ownerbugs instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ownerbugs instance) {
		log.debug("attaching clean Ownerbugs instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OwnerbugsDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (OwnerbugsDAOImpl) ctx.getBean("OwnerbugsDAO");
	}
}