package lab.academico.aluno;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Data Access Object.
 */
public class AlunoDao {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab-persistence-unit");

	public static void inclui(String matricula, String nome) {
		// Obter "conexão".
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);

		// Grava o objeto no banco de dados.
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	
	}

	public static void alterar(String matricula, String nome) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Aluno aluno = em.find(Aluno.class, matricula);
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		
		em.persist(aluno);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(String matricula) {
		//Iniciando a conexão
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//Selecionando o aluno pela matricula
		Aluno aluno = em.find(Aluno.class, matricula);
		aluno.getMatricula();
		
		//Remove o objeto do banco de dados
		em.remove(aluno);
		em.getTransaction().commit();
		em.close();		
	}

	public static List<Aluno> listar() {
		EntityManager em = emf.createEntityManager();
		String jpql = "from Aluno";
		TypedQuery<Aluno> query = em.createQuery(jpql, Aluno.class);
		List<Aluno> result = query.getResultList();
		em.close();
		return result;
	}
}
