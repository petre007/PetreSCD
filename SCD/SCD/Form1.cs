using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using SCD.Model;

namespace SCD
{
    public partial class Form1 : Form
    {
        List<Employee> employeeList = new List<Employee>();
        private Service.Service Service = new Service.Service();
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Department department = new Department();
            department.Id = 1;
            department.Description = "Fetti este gras";
            employeeList = Service.getAllEmployeeByDepartment(department);
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Department department = new Department();
            department.Id = 1;
            department.Description = "Fetti este gras";
            employeeList = Service.getAllEmployeeByDepartment(department);
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            dataGridView1.DataSource = employeeList;
        }
    }
}