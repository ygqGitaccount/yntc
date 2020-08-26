package yntc.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.Goods;

public interface GoodsDao {
    public List<Goods> findAll() throws Exception;
    public int addGoods(Goods goods, HttpSession session);
    public Goods findGoodsById(int id);
    public List<Goods> findGoodsByState(int currentPage,int pageSize,HttpSession session) throws Exception;
    public int updateGoods(Goods goods);
    public int deleteGoodsById(int id);
    public Integer count(HttpSession session);
    public List<Goods> findGoodsByState(int state);
    public List<Goods> findMoreFood();
    public List<Goods> findMoreHandicraft();
    public List<Goods> findMoreFruit();
    public List<Goods> findMoreMeat();
    public List<Goods> findMoreDryCargo();
    public List<Goods> searchGoodsByName(String word);
    public List<String> searchGoodsByLikeName(String word);
    public int updateGoodsNumRaduce(int goodsid,int number);
    public Goods findStoreName(int state);
    public List<Goods> findGoodsByType(String type,int state);
    public List<Goods> findGoodsAll(int state);
    public int updateGoodsNumberAdd(int number,int gid);
}
