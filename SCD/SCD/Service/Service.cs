using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using SCD.Model;


namespace SCD.Service
{
    public class Service
    {
        static HttpClient client = new HttpClient();

        public void createConnection()
        {
            // Update port # in the following line.
            client.BaseAddress = new Uri("http://localhost:8080/");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public List<Employee> getAllEmployeeByDepartment(Department department)
        {

            List<Employee> employees = null;

            var myContent = JsonConvert.SerializeObject(department);
            
            var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
            var byteContent = new ByteArrayContent(buffer);
            
            HttpResponseMessage httpResponseMessage = client.PostAsync("employee-by-departments", byteContent).Result;

            if (httpResponseMessage.IsSuccessStatusCode)
            {
                string resultString = httpResponseMessage.Content.ReadAsStringAsync().Result;
                JsonReader jsonReader = new JTokenReader(resultString);
                employees = new JsonSerializer().Deserialize<List<Employee>>(jsonReader);
                return employees;
            }
            
            return null;
        }
        
        public List<Employee> getAllManagersByDepartment(Request request)
        {

            List<Employee> employees = null;

            var myContent = JsonConvert.SerializeObject(request);
            
            var buffer = System.Text.Encoding.UTF8.GetBytes(myContent);
            var byteContent = new ByteArrayContent(buffer);
            
            HttpResponseMessage httpResponseMessage = client.PostAsync("manager-by-departments", byteContent).Result;

            if (httpResponseMessage.IsSuccessStatusCode)
            {
                string resultString = httpResponseMessage.Content.ReadAsStringAsync().Result;
                JsonReader jsonReader = new JTokenReader(resultString);
                employees = new JsonSerializer().Deserialize<List<Employee>>(jsonReader);
                return employees;
            }
            
            return null;
        }
    }
}