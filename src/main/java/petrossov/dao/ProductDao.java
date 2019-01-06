package petrossov.dao;


import petrossov.Models.*;



public interface ProductDao extends CrudDao<Product> {
   void saveById (Product model);
}
