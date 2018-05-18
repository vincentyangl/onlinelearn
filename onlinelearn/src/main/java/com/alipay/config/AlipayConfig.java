package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *������AlipayConfig
 *���ܣ�����������
 *��ϸ�������ʻ��й���Ϣ������·��
 *�޸����ڣ�2017-04-05
 *˵����
 *���´���ֻ��Ϊ�˷����̻����Զ��ṩ���������룬�̻����Ը����Լ���վ����Ҫ�����ռ����ĵ���д,����һ��Ҫʹ�øô��롣
 *�ô������ѧϰ���о�֧�����ӿ�ʹ�ã�ֻ���ṩһ���ο���
 */

public class AlipayConfig {
	
//�����������������������������������Ļ�����Ϣ������������������������������

	// Ӧ��ID,����APPID���տ��˺ż�������APPID��Ӧ֧�����˺�
	public static String app_id = "2016082000291689";
	
	// �̻�˽Կ������PKCS8��ʽRSA2˽Կ
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC5y6uCfrgLGm5g4YlsQhQlVJZr8qP8cNVQ8GyNErmzyl4xGkTUxMkUKZyb4lxHTpdx0vVxSVsCBXcXZT6G1jNvkxsXMRzN5fxRS5OlaslAIC9aJa4DekXH5MThs+WztF27CXtj10aQD6l0l3O2l449WZqA4PKOCkTyLO0E7ez2sV4wEpSA7U2vYN1m+EnyAj62oD/NPy+RdOggKmTblwNts7K3UzeN6kmaHuoa1A4Qt0peB6kA56Hekvmkgii7FzV31XeA3U2etqMDtFzNF4G4678wYKlWhIYFBG5g/vRfYHmsC4FRpKx3sVeP0R2ki+ov1YGAShhBsZaFoEQs/kxZAgMBAAECggEBAKbfROXpxodCcAzXxMPU/Z8hwBCoV5zuAsm1humV/fB7O+pCO7wWGrvfO+fOgS8SaXc0EHp1diX0nqgGqQgV7xCxQU2tML/FZr/lb3DM3oCX56/B0+8PrQkCccp99ztWLjFFLOvZeGj/iCVNugIvUPPNPLWwVGo60v3oV+FriL9vtzZL4tK0rdZ9HAHq7hjgtQ07tgfrd8X9UVYfET5oZ5vgJEZ8uhReQcEtoxSZ74dWSgwLcRWjCiylFnrN9UQBCv26+BCsi+4zSfsn77w/T2aRzSeNZp2eK4reZVTTr7ATU1GlFHc/XLhu0eaOATcZtudbr8ZYn+3WxBJhPt09zOECgYEA+mEQQB6jTPh/JzTSnPyVsWGbJkoY9/o9tvM4zaWMO49FYBtTjna585/pfwTR1YoXVA7T4dqO5oS8kk4+ApSRlGUYVyFMEmJkj4hs9BRcNmkIK1j2erObJr5+7F5bwRiV+DldVoe7kZmx+oqhTnaq7fC0a2WCPo3yI9dgW/SjX+UCgYEAvfdxWZmw1y7+F5YfGYF419VZ+yF18nwmgMJED+cHNuAg0fDzYn2F4hnWn3vKuZpwvd+PyKQmVatGOWkNetZf2RzxK1olRiYVGaNVxB9m5WCIRcSq4SW7FVpLBQBlybk69cZkIqVKmr3wAmdqzV+1GjLsRiL0kTVZg0oZqfbWK2UCgYBfQTAyhLVx4hRV8SWzbfDxVAX3sjb/mKeEA9J3gmTwf9hP8PV//LFP+2WU2luOVwP7Cc0YXtMA5jzrmHLE/orIHxH8jAFp+R7y8F8rGNfgJ2NhQm47TjtXqR+Wg2t68gSUNBbLhcYZZZStkbI+rKzo6ytotGyxqcUWV6kkMtU49QKBgHDqYvLaWvYdFaWZcxTrE5RfWePfKMegqhZA4sn9Dhm9MWT47wJtECasKxmTMJYQSdFi0Il3oN2tN8mqOvv37vMTs/qL07oVqtcZckJoU/Yl4fpugw/fKIvxpsPrT5WPR4+NhDnfvC+slLwpEp/OssxG1pB9+JdTeciDRCv176nNAoGBAIDqurBBRvrB9RQE5s3wOVynPGXn/zJsh1lvG8iraLnYuCN8Xwy2b7Fz6o14vTFWZs09TOya44x+xh0op6Sp+MFgXlMUUTcaWpl0aauAPngiG58gTQYIJL6bAMJhwlVr0+dKnYml9iXZgyYLVAOndeDxFlEDBBDQwipw/1/64Dhx";
	
	// ֧������Կ,�鿴��ַ��https://openhome.alipay.com/platform/keyManage.htm ��ӦAPPID�µ�֧������Կ��
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4eb0EK6DUABPxq/34zptQMQIy+SPdoUue9BziaNhT2SC0t4iB95FfPrCrH42aQRPhLDK4OWmdqbBDW7hUlTnOLD7QXFn6FndhxUjissUtvHKvYvPqK7F7CH97f8LKP5czzRHBjwPhpE8OxgiwEpnJJr5nsUjx2neXKogQuBBbmQFmSuhZyEIgrwz52xAQIOIp/gv5dIwrpPAKDivNPOLqmW+BzEVa5stmP5DmQ+tDsIZs3yQq+hXZPdE6s6bZxD13fbCgVOFeNS2o3qj/SDA1Tqqt1gaNR7Xaa8hbZYjFgynCUtYfhyo9vkYnzN2TJWuFX2f7YUwLK2/fR3frQTEGwIDAQAB";

	// �������첽֪ͨҳ��·��  ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String notify_url = "http://localhost:8080/notify_url.jsp";

	// ҳ����תͬ��֪ͨҳ��·�� ��http://��ʽ������·�������ܼ�?id=123�����Զ����������������������������
	public static String return_url = "http://localhost/return_url.jsp";

	// ǩ����ʽ
	public static String sign_type = "RSA2";
	
	// �ַ������ʽ
	public static String charset = "utf-8";
	
	// ֧��������
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// ֧��������
	public static String log_path = "C:\\";


//�����������������������������������Ļ�����Ϣ������������������������������

    /** 
     * д��־��������ԣ�����վ����Ҳ���ԸĳɰѼ�¼�������ݿ⣩
     * @param sWord Ҫд����־����ı�����
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

