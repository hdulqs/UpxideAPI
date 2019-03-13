package com.gop.exchange.util;

import com.alibaba.fastjson.JSONObject;

import javax.net.ssl.*;
import javax.security.cert.X509Certificate;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;

public class HttpUtil {
/*
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static final OkHttpClient client = trustAllSslClient(new OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .build());

    public static String post(String url, String msg) throws IOException {

        RequestBody body = RequestBody.create(JSON, msg);
        Request request = new Request.Builder()
                .url(url).post(body).addHeader("Accept-Language", " ko-KR")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();

    }

    *//*
     * This is very bad practice and should NOT be used in production.
     *//*
    private static final TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[]{};
                }
            }
    };
    private static final SSLContext trustAllSslContext;

    static {
        try {
            trustAllSslContext = SSLContext.getInstance("SSL");
            trustAllSslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
    }

    private static final SSLSocketFactory trustAllSslSocketFactory = trustAllSslContext.getSocketFactory();

    *//*
     * This should not be used in production unless you really don't care
     * about the security. Use at your own risk.
     *//*
    public static OkHttpClient trustAllSslClient(OkHttpClient client) {
        OkHttpClient.Builder builder = client.newBuilder();
        System.out.println(trustAllSslSocketFactory == null);
        System.out.println(trustAllCerts == null);
        builder.sslSocketFactory(trustAllSslSocketFactory, (X509TrustManager) trustAllCerts[0]);
        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        return builder.build();
    }*/


    public static String post (String urlStr, String requestBody) {
        StringBuffer sb = new StringBuffer();
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true); 				// xml내용을 전달하기 위해서 출력 스트림을 사용
            conn.setInstanceFollowRedirects(false);  //Redirect처리 하지 않음
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("Accept", "application/json;charset=utf-8");
            OutputStream os= conn.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static String get (String urlStr) {
        StringBuffer sb = new StringBuffer();
        try {
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }};
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true); 				// xml내용을 전달하기 위해서 출력 스트림을 사용
            conn.setInstanceFollowRedirects(false);  //Redirect처리 하지 않음
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("charset", "utf-8");
//            OutputStream os= conn.getOutputStream();
//            os.write(requestBody.getBytes());
//            os.flush();
            InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }



    /*public static String get(String url) {

        TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }
        };

        if (null == url || "".equals(url)) {
            return null;
        }

        if (!url.startsWith("https://")) {
            return null;
        }

        HttpURLConnection connection = null;
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;

        try {
            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

            URL resturl = new URL(url);

            connection = (HttpsURLConnection)resturl.openConnection();
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("User-Agent", "Mozilla/5.0 ");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Type", "application/json");

            //Reader reader = new InputStreamReader(connection.getInputStream());
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        BigInteger bigInteger = new BigInteger("2772064120");
        json.put("accountIndex", bigInteger);
        json.put("walletId", "Ae2tdPwUPEZ85tDJKmckCYtKmwdQQVkTWtjLDtC4MPWiPXLoEcNo3B3G2xg");
        json.put("spendingPassword", "5177657231323321517765723132332151776572313233215177657231323321");

        System.out.println(HttpUtil.post("https://52.79.148.106:8090/api/v1/addresses", json.toJSONString()));

//        System.out.println(HttpUtil.get("https://52.79.148.106:8090/api/v1/addresses"));
    }

}
