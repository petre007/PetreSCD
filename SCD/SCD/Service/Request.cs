using SCD.Model;

namespace SCD.Service
{
    public class Request
    {
       public Employee Manager { get; set; }
       public Department DepartmentEntity { get; set; }
    }
}