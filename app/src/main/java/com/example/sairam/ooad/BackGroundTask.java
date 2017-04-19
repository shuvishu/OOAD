package com.example.sairam.ooad;

/**
 * Created by sai ram on 17-04-2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by sai ram on 14-03-2017.
 */

public class BackGroundTask extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context c;
    BackGroundTask(Context c){
        this.c=c;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(c).create();
        alertDialog.setTitle("Login information");
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url="http://192.168.0.3/android_connect/add_mother.php";
        String login_url="http://192.168.0.3/android_connect/login_mo.php";
        String add_new_worker_url="http://192.168.0.3/android_connect/add_new_worker.php";
        String delete_worker_url="http://192.168.0.3/android_connect/delete_worker.php";
        String update_worker_url="http://192.168.0.3/android_connect/update_worker.php ";
        String method=params[0];
        if(method.equals("Register"))
        {

            String mname=params[1];
            String mid=params[2];
            String role=params[3];
            try {

                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data= URLEncoder.encode("newid","UTF-8")+"="+URLEncoder.encode(mname,"UTF-8")+"&"+
                        URLEncoder.encode("newname","UTF-8")+"="+URLEncoder.encode(mid,"UTF-8")+"&"+
                        URLEncoder.encode("role","UTF-8")+"="+URLEncoder.encode(role,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                return "Registeration Sucessfull";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (method.equals("login"))
        {
            String mname=params[1];
            String mid=params[2];
            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);//Because we are expecting a response from the serverM
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data=URLEncoder.encode("mname","UTF-8")+"="+URLEncoder.encode(mname,"UTF-8")+"&"+
                            URLEncoder.encode("mid","UTF-8")+"="+URLEncoder.encode(mid,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                //getting response from the server
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("addnewworker"))
        {
            String nwusername=params[1];
            String nwpass=params[2];
            String nwname=params[3];
            String nwcontact=params[4];

            try {
                URL url = new URL(add_new_worker_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data= URLEncoder.encode("nwusername","UTF-8")+"="+URLEncoder.encode(nwusername,"UTF-8")+"&"+
                        URLEncoder.encode("nwpass","UTF-8")+"="+URLEncoder.encode(nwpass,"UTF-8")+"&"+
                        URLEncoder.encode("nwname","UTF-8")+"="+URLEncoder.encode(nwname,"UTF-8")+"&"+
                        URLEncoder.encode("nwcontact","UTF-8")+"="+URLEncoder.encode(nwcontact,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                //getting response from the server
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(method.equals("updateworker"))
        {
            String UWusername=params[1];
            String contact=params[2];


            try {
                URL url = new URL(update_worker_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data= URLEncoder.encode("UWusername","UTF-8")+"="+URLEncoder.encode(UWusername,"UTF-8")+"&"+
                            URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                //getting response from the server
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("deleteworker"))
        {
            String delUserName=params[1];


            try {
                URL url = new URL(delete_worker_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream OS=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(OS,"UTF-8"));
                String data= URLEncoder.encode("delUserName","UTF-8")+"="+URLEncoder.encode(delUserName,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                //getting response from the server
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while ((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registeration Sucessfull")){Toast.makeText(c,result,Toast.LENGTH_LONG).show();}

        else if (result.equals(("already_exist").trim())){
            alertDialog.setTitle("Data base error");
            alertDialog.setMessage("worker with this user name already exist");
            alertDialog.show();

        }
        else if (result.equals(("new_worker_added").trim()))
        {
            Toast.makeText(c,"worker added successfully",Toast.LENGTH_SHORT).show();
            c.startActivity(new Intent(c,admin.class));
        }
        else if (result.equals(("worker_deleted").trim()))
        {
            Toast.makeText(c,"worker deletion success",Toast.LENGTH_SHORT).show();
            c.startActivity(new Intent(c,admin.class));
        }
        else if(result.equals(("worker_does_not_exist").trim()))
        {
            alertDialog.setTitle("worker does not exist");
            alertDialog.setMessage("worker with this user name does not exist, cant be deleted");
            alertDialog.show();
        }
        else if (result.equals(("worker_updated").trim()))
        {
            Toast.makeText(c,"worker updation success",Toast.LENGTH_SHORT).show();
            c.startActivity(new Intent(c,admin.class));
        }
        else if(result.equals(("worker_does_not_exist_to_update").trim()))
        {
            alertDialog.setTitle("worker does not exist");
            alertDialog.setMessage("worker with this user name does not exist, cant be updated");
            alertDialog.show();
        }
        else{
            String s=result.trim();
            switch (s)
            {
                case "admin":
                    c.startActivity(new Intent(c,admin.class));
                    break;
                case "worker":
                    c.startActivity(new Intent(c,worker.class));
                    break;
                case "mother":
                    c.startActivity(new Intent(c,mother.class));
                    break;
                case "NO info":
                    alertDialog.setMessage(result);
                     alertDialog.show();

            }

//            String s=result.trim();
//            if(s.equals("admin"))
//            {
//                c.startActivity(new Intent(c,admin.class));
//            }
//            else {
//                Toast.makeText(c,result+" in else",Toast.LENGTH_LONG).show();
//            }
////            alertDialog.setMessage(result);
////            alertDialog.show();
        }
    }
}