package com.realm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.bean.SysFunction;
import com.bean.SysUser;
import com.service.SysFunctionService;
import com.service.SysRoleService;
import com.service.SysUserService;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysFunctionService sysFunctionService;
	@Autowired
	private SysRoleService sysRoleService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//��ȡ�ĵ�¼����û���
		String loginName = (String) principals.getPrimaryPrincipal();
		SysUser sysUser = getUserByName(loginName).get(0);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> set = new HashSet<>();
		set.add(sysUser.getSysRole().getRoleName());
		//��װ��ɫ����
		authorizationInfo.setRoles(set);
		//��װ��ɫ��Ӧ��Ȩ�޼���
		authorizationInfo.setStringPermissions(getFunctionName(sysUser));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//  AuthenticationToken �Ǵ�handler�д������� UsernamePasswordToken ���ǵĹ�ϣ��һ��
		// 1.�� AuthenticationToken ת��Ϊ UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		// 2. ��UsernamePasswordToken�л�ȡ loginName
		String loginName = upToken.getUsername();
		// 3.�������ݿ�ķ����������ݿ��в�ѯusername��Ӧ���û���¼
		List<SysUser> sysUsers = getUserByName(loginName);
		//4.���û������ڣ�������׳� UnknownAccountException �쳣
		if (sysUsers.size()==0) {
			return null;
		}
		/*//5.�����û�����������Ƿ���Ҫ�׳����� AuthenticationException �쳣
			if ("monster".equals(username)) {
				throw new LockedAccountException("�û�������");
			}*/
		//6.�����û������������ AuthenticationInfo ���󲢷���,ͨ��ʹ�õ�ʵ������  SimpleAuthenticationInfo
		//������Ϣ�Ǵ����ݿ��л�ȡ��

		//1��principal��֤��ʵ����Ϣ������ʹusername,Ҳ���������ݱ��Ӧ���û���ʵ�����
		Object principal = loginName;
		//2)�����ݿ��л�ȡ������
		Object credentials = sysUsers.get(0).getLoginPwd();
		
		//3)realmName����ǰrealm�����name,���ø����getName() ��������
		String realmName = getName();
		//��ֵ
		ByteSource salt = ByteSource.Util.bytes(loginName);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials,salt, realmName);
		System.out.println(info);
		return info;
	}
	
	public Set<String> getFunctionName(SysUser sysUser) {
		Set<String> set = new HashSet<>();
		List<SysFunction> sysFunctions = sysUser.getSysRole().getSysFunctions();
		for (SysFunction permissions2 : sysFunctions) {
			set.add(permissions2.getName());
		}
		return set;
	}

	public List<SysUser> getUserByName(String loginName) {
		Map map = new HashMap<>();
		map.put("loginName", loginName);
		List<SysUser> sysUsers = sysUserService.listAll(map);
		return sysUsers;
	}
	

	public static void main(String[] args) {
		
		String hashAlgorithName="MD5";
		String pass="888888";
		Object salt=ByteSource.Util.bytes("jack");
		int count=1024;
		Object result=new SimpleHash(hashAlgorithName, pass,salt,count);
		System.out.println("result:"+result);
		
	}
	
}
