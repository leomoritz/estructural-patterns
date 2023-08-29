package br.com.cod3r.bridge.mvc;

import br.com.cod3r.bridge.mvc.dao.UserMongoDao;
import br.com.cod3r.bridge.mvc.dao.UserMysqlDao;
import br.com.cod3r.bridge.mvc.dao.UserOracleDao;
import br.com.cod3r.bridge.mvc.dao.UserPostgresDao;
import br.com.cod3r.bridge.mvc.model.User;
import br.com.cod3r.bridge.mvc.services.UserEJB;
import br.com.cod3r.bridge.mvc.services.UserRest;
import br.com.cod3r.bridge.mvc.services.UserService;
import br.com.cod3r.bridge.mvc.services.UserSoap;

public class Client {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		User user = new User("user", "user@email.com", "passwd");

		System.out.println("\n/-------------------* USER EJB *-------------------/");
		UserService userEjbMongo = new UserEJB(new UserMongoDao());
		userEjbMongo.save(user);

		UserService userEjbMysql = new UserEJB(new UserMysqlDao());
		userEjbMysql.save(user);

		UserService userEjbOracle = new UserEJB(new UserOracleDao());
		userEjbOracle.save(user);

		UserService userEjbPostgres = new UserEJB(new UserPostgresDao());
		userEjbPostgres.save(user);

		System.out.println("\n/-------------------* USER SOAP *-------------------/");
		UserService userSoapMongo = new UserSoap(new UserMongoDao());
		userSoapMongo.save(user);

		UserService userSoapMysql = new UserSoap(new UserMysqlDao());
		userSoapMysql.save(user);

		UserService userSoapOracle = new UserSoap(new UserOracleDao());
		userSoapOracle.save(user);

		UserService userSoapPostgres = new UserSoap(new UserPostgresDao());
		userSoapPostgres.save(user);

		System.out.println("\n/-------------------* USER REST *-------------------/");
		UserService userRestMongo = new UserRest(new UserMongoDao());
		userRestMongo.save(user);

		UserService userRestMysql = new UserRest(new UserMysqlDao());
		userRestMysql.save(user);

		UserService userRestOracle = new UserRest(new UserOracleDao());
		userRestOracle.save(user);

		UserService userRestPostgres = new UserRest(new UserPostgresDao());
		userRestPostgres.save(user);
	}
}
