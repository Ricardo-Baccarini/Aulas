/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import model.ModelProdutos;
import java.util.ArrayList;

/**
 *
 * @author ricar
 */
public class DaoProdutos extends ConexaoMySql {

    /**
     * Adicionar um produto no banco
     * @param pModelProdutos
     * @return 
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.insertSQL(
                    "insert into tbl_Produto ("
                    + "pro_nome,"
                    + "pro_valor,"
                    + " pro_estoque) values("
                    + "'" + pModelProdutos.getProNome() + "',"
                    + "'" + pModelProdutos.getProValor() + "',"
                    + "'" + pModelProdutos.getProEstoque() + "'"
                    + ")"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * Excluir um produto do banco
     * @param pIdProduto
     * @return boolean
     */
    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "delete "
                    + "from tbl_Produto "
                    + "where pk_id_produto = '" + pIdProduto + "'");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
    /**
     * Altera um produto no banco de dados
     * @param pModelProdutos
     * @return boolean
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "update tbl_produto set "
                    + "pro_nome = '" + pModelProdutos.getProNome() + "',"
                    + "pro_valor = '" + pModelProdutos.getProValor() + "',"
                    + "pro_estoque = '" + pModelProdutos.getProEstoque() + "'"
                    + "pro_estoque = '" + pModelProdutos.getProEstoque() + "'"
                    + " where pk_id_produto = '" + pModelProdutos.getIdProduto() + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
    
   /**
    * retorna um produto pelo código
    * @param pIdProduto
    * @return ModelProdutos
    */
    public ModelProdutos retornarProdutoDAO(int pIdProduto) {
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_estoque "
                    + "FROM tbl_produto where pk_id_codigo = '"+pIdProduto+"'");
            while (this.getResultSet().next()) {                
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProdutos;
    }
    
    /**
     * retorna uma lista de produtos
     * @return listaModelProdutos
     */
    public ArrayList<ModelProdutos> retornaListaProdutosDAO(){
        ArrayList<ModelProdutos> listaModelProdutos = new ArrayList<>();
        ModelProdutos modelProdutos = new ModelProdutos();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "pk_id_produto, "
                    + "pro_nome, "
                    + "pro_valor, "
                    + "pro_estoque "
                    + "FROM tbl_produto");
            while (this.getResultSet().next()) {
                modelProdutos = new ModelProdutos(); /** Possivel nao precisar */
                modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                modelProdutos.setProNome(this.getResultSet().getString(2));
                modelProdutos.setProValor(this.getResultSet().getDouble(3));
                modelProdutos.setProEstoque(this.getResultSet().getInt(4));
                listaModelProdutos.add(modelProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaModelProdutos;
    }
}
