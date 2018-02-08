/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

/**
 *
 * @author ricar
 */
public class ControllerProdutos {
    
    private DaoProdutos daoProdutos = new DaoProdutos();
    
    /**
     * salvarProdutoController
     * @param pModelProdutos
     * @return 
     */
    public int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
    }
    
    /**
     * excluir um produto pelo codigo
     * @param pIdProduto
     * @return 
     */
    public boolean excluirProdutoController(int pIdProduto) {
        return this.daoProdutos.excluirProdutoDAO(pIdProduto);
    }
    
    /**
     * altera um produto cadastrado
     * @param pModelProdutos
     * @return 
     */
    public boolean alterarProdutoController(ModelProdutos pModelProdutos) {
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }
    
    /**
     * retorna um produto pelo codigo
     * @param pCodigo
     * @return 
     */
    public ModelProdutos retornarProdutoController(int pCodigo) {
        return this.daoProdutos.retornarProdutoDAO(pCodigo);
    }
    
    /**
     * retorna uma lista de produtos
     * @return 
     */
    public ArrayList<ModelProdutos> retornaListaProdutosController(){
        return this.daoProdutos.retornaListaProdutosDAO();
    }
}
