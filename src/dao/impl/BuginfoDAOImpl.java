package dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IBuginfoDAO;

import bean.Buginfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Buginfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see bean.Buginfo
 * @author MyEclipse Persistence Tools
 */
public class BuginfoDAOImpl extends HibernateDaoSupport implements IBuginfoDAO{
	private static final Logger log = LoggerFactory.getLogger(BuginfoDAOImpl.class);
	// property constants
	public static final String BUG_ID = "bugId";
	public static final String TITLE = "title";
	public static final String PROJECT = "project";
	public static final String TYPE = "type";
	public static final String STATUS = "status";
	public static final String DESCRIPTION = "description";
	public static final String OWNER = "owner";
	public static final String SUBMITTER = "submitter";
	public static final String SEVERITY = "severity";
	public static final String TAGS = "tags";
	public static final String REGRESSION = "regression";
	public static final String COMPONENT = "component";

	protected void initDao() {
		// do nothing
	}

	public void save(Buginfo transientInstance) {
		log.debug("saving Buginfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Buginfo persistentInstance) {
		log.debug("deleting Buginfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Buginfo findById(java.lang.Integer id) {
		log.debug("getting Buginfo instance with id: " + id);
		try {
			Buginfo instance = (Buginfo) getHibernateTemplate().get(
					"bean.Buginfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Buginfo instance) {
		log.debug("finding Buginfo instance by example");
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
		log.debug("finding Buginfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Buginfo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBugId(Object bugId) {
		return findByProperty(BUG_ID, bugId);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByProject(Object project) {
		return findByProperty(PROJECT, project);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findByOwner(Object owner) {
		return findByProperty(OWNER, owner);
	}

	public List findBySubmitter(Object submitter) {
		return findByProperty(SUBMITTER, submitter);
	}

	public List findBySeverity(Object severity) {
		return findByProperty(SEVERITY, severity);
	}

	public List findByTags(Object tags) {
		return findByProperty(TAGS, tags);
	}

	public List findByRegression(Object regression) {
		return findByProperty(REGRESSION, regression);
	}

	public List findByComponent(Object component) {
		return findByProperty(COMPONENT, component);
	}

	public List findAll() {
		log.debug("finding all Buginfo instances");
		try {
			String queryString = "from Buginfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Buginfo merge(Buginfo detachedInstance) {
		log.debug("merging Buginfo instance");
		try {
			Buginfo result = (Buginfo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Buginfo instance) {
		log.debug("attaching dirty Buginfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Buginfo instance) {
		log.debug("attaching clean Buginfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BuginfoDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (BuginfoDAOImpl) ctx.getBean("BuginfoDAO");
	}
}