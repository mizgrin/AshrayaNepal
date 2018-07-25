package com.ssm.ashrayanepal.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users")
public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		public Long userId;
/*		@Column(unique=true)*/
 		/*@OneToOne*/

		private String userName;
		private  String userEmail;
		private String userPassword;
		@Transient
		private String userPasswordConfirm;
		@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(name="users_roles",joinColumns ={ @JoinColumn(name="user_id",unique= false,referencedColumnName="userId")},inverseJoinColumns={@JoinColumn(name="role_id",unique= false ,referencedColumnName="id")})
		@Column(name="Role")
		private Set<Role> roles=new HashSet<Role>();

		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public String getUserPasswordConfirm() {
			return userPasswordConfirm;
		}
		public void setUserPasswordConfirm(String userPasswordConfirm) {
			this.userPasswordConfirm = userPasswordConfirm;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
		
		
}

		