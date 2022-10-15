package br.com.hector.store.testes;

import br.com.hector.store.dao.CategoriaDao;
import br.com.hector.store.dao.ProdutoDao;
import br.com.hector.store.modelo.Categoria;
import br.com.hector.store.modelo.Produto;
import br.com.hector.store.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1l;
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        Produto p = produtoDao.buscarPorId(id);
        System.out.println(p.getPreco());

        List<Produto> lista = produtoDao.buscarPorNomeDaCategoria("celulares");
        for (Produto pr:
             lista) {
            System.out.println(pr.getNome());
        }

        BigDecimal preco = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println(preco);

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("Celulares");
        Produto celular = new Produto("Xiaomi Redmi", "top", new BigDecimal(800), celulares);

        //conectando a camada de persistencia
        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao dao = new ProdutoDao(em);
        categoriaDao.cadastrar(celulares);
        dao.cadastrar(celular);

        em.getTransaction().begin();
        em.persist(celular);

        em.getTransaction().commit();
        em.close();
    }
}
