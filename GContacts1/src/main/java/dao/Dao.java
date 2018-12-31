package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class Dao<E> {
	private static SessionFactory factory;

	/** Génerique **/
	public boolean add(E v) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(v);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}

	}

	public boolean addOrUpdate(E v) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(v);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}

	}

	public ArrayList<E> getAll(String _Class) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			ArrayList<E> list = (ArrayList<E>) session.createQuery("from " + _Class).list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public boolean update(E entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entity);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public boolean delete(String s, Class<E> c) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			E u = (E) session.get(c, s);
			session.delete(u);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public boolean delete(int id, Class<E> c) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			E u = (E) session.get(c, id);
			session.delete(u);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public E getById(int i, Class<E> class1) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		E u = null;
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			u = (E) session.get(class1, i);
			session.getTransaction().commit();
			return u;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public E getByCode(String code, Class<E> class1) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		E u = null;
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			u = (E) session.get(class1, code);
			session.getTransaction().commit();
			return u;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public E getByLogin(String login, String password, String _T) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		E u = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session
					.createQuery("from " + _T + " where login='" + login + "' and password='" + password + "'");
			u = (E) q.uniqueResult();
			tx.commit();
			return u;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public E getWhere(String _T, String _con) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		E u = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from " + _T + " where " + _con + " ");
			u = (E) q.uniqueResult();
			tx.commit();
			return u;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public List<E> getAllWhere(String _T, String cond) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<E> list = session.createQuery("from " + _T + " where " + cond).list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public List<E> selectSql(String _Col, String _T, String cond) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<E> list = session.createSQLQuery("select " + _Col + " from " + _T + " where " + cond).list();
			tx.commit();
			return list;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public int getCount(String tab) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int count = ((Long) session.createQuery("select count(*) from " + tab).uniqueResult()).intValue();
			return count;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

	public int getCountWhere(String tab, String _con) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			int count = ((Long) session.createQuery("select count(*) from " + tab + " where " + _con + " ")
					.uniqueResult()).intValue();
			return count;
		} catch (HibernateException e) {
			e.printStackTrace();
			return 0;
		} finally {
			if (session.isConnected()) {
				session.close();
			}
		}
	}

}
