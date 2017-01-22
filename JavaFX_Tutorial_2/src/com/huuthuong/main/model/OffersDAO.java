package com.huuthuong.main.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.access.annotation.*;


@Component("offersDao")
public class OffersDAO {
    
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource jdbc) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(jdbc);
	}

	public int createOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return this.jdbcTemplate.update("insert into offers (name, mail, text) value(:name,:mail,:text)", params);
	}
	
	@Transactional
    public int[] createOffers(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return this.jdbcTemplate.batchUpdate("insert into offers (id,name, mail, text) value(:id,:name,:mail,:text)", params);
	}
	
	public int updateOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return this.jdbcTemplate.update("update offers set name=:name, text=:text, mail=:mail where id=:id", params);
	}
	
	@Secured("ROLE_MANAGER")
	public int deleteOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return this.jdbcTemplate.update("delete from offers where id=:id", params);
	}
	
	@Transactional
	@Secured("ROLE_MANAGER")
	public int[] deleteOffers(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		return this.jdbcTemplate.batchUpdate("delete from offers where id=:id", params);
	}
	
	@Secured("ROLE_MANAGER")
	public int deleteOffer(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return this.jdbcTemplate.update("delete from offers where id=:id", params);
	}

	@SuppressWarnings("unchecked")
	public List<Offer> getOffers() {
		
		return this.jdbcTemplate.query("select * from offers", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				return parseOffer(arg0);
			}
			
		});
	}

	public Offer getOffer(int id, String name) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		params.addValue("name", name);

		return this.jdbcTemplate.queryForObject("select * from offers where id=:id and name=:name", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet arg0, int arg1) throws SQLException {
				return parseOffer(arg0);
			}
			
		});
	}
	
	private Offer parseOffer(ResultSet arg0) throws SQLException {
		Offer offer = new Offer();
		offer.setId(arg0.getInt("id"));
		offer.setName(arg0.getString("name"));
		offer.setMail(arg0.getString("mail"));
		offer.setText(arg0.getString("text"));
		return offer;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Offers \n");
		try {
			List<Offer> offers = this.getOffers();
			for(Offer offer : offers) {
				sb.append(offer + "\n");
			}
		} 
		catch (Exception e) {
			sb.append(e.getMessage() + "\n" + e.getClass() + "\n");
		}
		
		return sb.toString();
	}
	
	
}
