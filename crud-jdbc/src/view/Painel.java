package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DepartmentController;
import controller.SellerController;
import entities.Department;
import entities.Seller;


public class Painel extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblName, lblEmail, lblBirthDate, lblBaseSalary, lblDepartment;
	private JTextField txfName, txfEmail, txfBirthDate, txfBaseSalary;
	private JComboBox<Department> cbxDepartment;
	private JButton btnSave, btnEdit, btnClear, btnDelete;
	private JTable table;
	private DefaultTableModel model;
	private SellerController sellerController;
	private DepartmentController departmentController;

	public Painel() {
		super("Departments");
		Container container = getContentPane();
		setLayout(null);

		this.sellerController = new SellerController();
		this.departmentController = new DepartmentController();

		lblName = new JLabel("Name");
		lblEmail = new JLabel("E-mail");
		lblBirthDate = new JLabel("Birth Date");
		lblBaseSalary = new JLabel("Base Salary");
		lblDepartment = new JLabel("Department");

		lblName.setBounds(10, 10, 250, 15);
		lblEmail.setBounds(350, 10, 250, 15);
		lblBirthDate.setBounds(10, 50, 250, 15);
		lblBaseSalary.setBounds(350, 50, 200, 15);
		lblDepartment.setBounds(10, 90, 250, 15);
		
		lblName.setForeground(Color.BLACK);;
		lblEmail.setForeground(Color.BLACK);;
		lblBirthDate.setForeground(Color.BLACK);;
		lblBaseSalary.setForeground(Color.BLACK);;
		lblDepartment.setForeground(Color.BLACK);;		

		container.add(lblName);
		container.add(lblEmail);
		container.add(lblBirthDate);
		container.add(lblBaseSalary);
		container.add(lblDepartment);		

		txfName = new JTextField();
		txfEmail = new JTextField();
		txfBirthDate = new JTextField();
		txfBaseSalary = new JTextField();
		
		txfName.setBounds(10, 25, 300, 20);
		txfEmail.setBounds(350, 25, 300, 20);	
		txfBirthDate.setBounds(10, 65, 200, 20);	
		txfBaseSalary.setBounds(350, 65, 200, 20);	
		
		container.add(txfName);
		container.add(txfEmail);
		container.add(txfBirthDate);
		container.add(txfBaseSalary);		
		
		cbxDepartment = new JComboBox<Department>();

		cbxDepartment.addItem(new Department(0, "Select"));
		List<Department> departments = this.findAllDepartment();
		for (Department department : departments) {
			cbxDepartment.addItem(department);
		}

		cbxDepartment.setBounds(10, 105, 265, 20);
		container.add(cbxDepartment);

		btnSave = new JButton("Save");
		btnClear = new JButton("Clear");

		btnSave.setBounds(10, 145, 80, 20);
		btnClear.setBounds(100, 145, 80, 20);

		container.add(btnSave);
		container.add(btnClear);

		table = new JTable();
		model = (DefaultTableModel) table.getModel();

		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("E-MAIL");
		model.addColumn("BIRTH DATE");
		model.addColumn("BASE SALARY");
		model.addColumn("DEPARTMENT ID");

		fillTable();

		table.setBounds(10, 185, 775, 300);
		container.add(table);

		btnDelete = new JButton("Delete");
		btnEdit = new JButton("Edit");

		btnDelete.setBounds(10, 500, 80, 20);
		btnEdit.setBounds(100, 500, 80, 20);

		container.add(btnDelete);
		container.add(btnEdit);

		setSize(800, 600);
		setVisible(true);
		setLocationRelativeTo(null);

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				clearTable();
				fillTable();
			}
		});

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

//		botarApagar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				deletar();
//				limparTabela();
//				preencherTabela();
//			}
//		});
//
//		botaoEditar.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				alterar();
//				limparTabela();
//				preencherTabela();
//			}
//		});
	}

	private void clearTable() {
		model.getDataVector().clear();
	}

//	private void alterar() {
//		Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
//		if (objetoDaLinha instanceof Integer) {
//			Integer id = (Integer) objetoDaLinha;
//			String nome = (String) modelo.getValueAt(tabela.getSelectedRow(), 1);
//			String descricao = (String) modelo.getValueAt(tabela.getSelectedRow(), 2);
//			this.produtoController.alterar(nome, descricao, id);
//		} else {
//			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
//		}
//	}
//
//	private void deletar() {
//		Object objetoDaLinha = (Object) modelo.getValueAt(tabela.getSelectedRow(), tabela.getSelectedColumn());
//		if (objetoDaLinha instanceof Integer) {
//			Integer id = (Integer) objetoDaLinha;
//			this.produtoController.deletar(id);
//			modelo.removeRow(tabela.getSelectedRow());
//			JOptionPane.showMessageDialog(this, "Item exclu�do com sucesso!");
//		} else {
//			JOptionPane.showMessageDialog(this, "Por favor, selecionar o ID");
//		}
//	}
//
	private void fillTable() {
		List<Seller> sellers = listSeller();
		try {
			for (Seller seller : sellers) {
				model.addRow(
						new Object[] { seller.getId(), seller.getName(), 
						seller.getEmail(), seller.getBirthDate(), 
						seller.getBaseSalary(), seller.getDepartment()});
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private List<Department> findAllDepartment() {
		return this.departmentController.findAll();
	}

	private void save(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (!txfName.getText().equals("") && !txfEmail.getText().equals("") 
					&& !txfBirthDate.getText().equals("") && !txfBaseSalary.getText().equals("")) {
				Seller seller = new Seller(txfName.getText(), txfEmail.getText(), 
						sdf.parse(txfBirthDate.getText()), Double.parseDouble(txfBaseSalary.getText()));			
				
				Department department = (Department) cbxDepartment.getSelectedItem();
				seller.setDepartment(department);
				this.sellerController.insert(seller);
				JOptionPane.showMessageDialog(this, "Success!" );
				this.limpar();
			
		} else {
			JOptionPane.showMessageDialog(this, "Fill all fields " + cbxDepartment.getSelectedItem().toString());
		}
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private List<Seller> listSeller() {
		return this.sellerController.findAll();
	}

	private void limpar() {
		this.txfName.setText("");
		this.txfEmail.setText("");
		this.txfBirthDate.setText("");
		this.txfBaseSalary.setText("");
		this.cbxDepartment.setSelectedIndex(0);
	}
}
