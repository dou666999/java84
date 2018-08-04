import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class createIndex {
    @Test
    public void createIndexBySolr() throws Exception {
        //连接solr服务
        String url = "http://localhost:8080/solr/collection1";
        HttpSolrServer httpSolrServer = new HttpSolrServer(url);

        //创建SolrInputDocument对象
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id","1");
        doc.addField("title","华为手机");
        doc.addField("content","国产骄傲");
        //添加索引
        httpSolrServer.add(doc);
        httpSolrServer.commit();

    }

    //更新
    @Test
    public void updataIndexBySolr() throws Exception {
        //连接solr服务
        String url = "http://localhost:8080/solr/collection1";
        HttpSolrServer httpSolrServer = new HttpSolrServer(url);
        //创建SolrInputDocument对象
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id","1");
        doc.addField("title","vivo手机");
        doc.addField("content","国产手机");
        //添加索引
        httpSolrServer.add(doc);
        httpSolrServer.commit();

    }

    //删除
    @Test
    public void delete() throws IOException, SolrServerException {
        //连接服务
        String url = "http://localhost:8080/solr/collection1";
        HttpSolrServer httpSolrServer = new HttpSolrServer(url);
        //根据id删除\
        httpSolrServer.deleteById("1");
        httpSolrServer.commit();
    }

    //删除
    @Test
    public void deleteByQuery() throws IOException, SolrServerException {
        //连接服务
        String url = "HTTP://localhost:8080/solr/collection1";
        SolrServer solrServer = new HttpSolrServer(url);

        solrServer.deleteByQuery("title:手机");
        solrServer.commit();
    }

}
