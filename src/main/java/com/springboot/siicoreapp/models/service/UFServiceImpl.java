package com.springboot.siicoreapp.models.service;


import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.siicoreapp.models.entity.CategoriaProducto;
import com.springboot.siicoreapp.models.entity.Producto;
import com.springboot.siicoreapp.models.repository.CategoriaProductoRepository;
import com.springboot.siicoreapp.models.repository.ProductoRepository;

@Service
public class UFServiceImpl implements UFService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaProductoRepository categoriaRepository;
	
	@Override
	public boolean saveDataFromUploadFile(MultipartFile file) {
		boolean isFlag = false;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if (extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")) {
			isFlag = readDataFromExcel(file);
		}
		return isFlag;
	}

	private boolean readDataFromExcel(MultipartFile file) {
		Workbook workbook = getWorkBook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		CategoriaProducto categoria = null;
		//rows.next();
		
		while (rows.hasNext()) {
			
			try {
				Row row = rows.next();
				Producto producto = new Producto();
				
				if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String id = NumberToTextConverter.toText(row.getCell(0).getNumericCellValue());
					System.out.println("CATEGORIA: "+id);
					Long idCategoria = Long.parseLong(id);
					categoria = categoriaRepository.findById(idCategoria).orElse(null);
					
					if (categoria == null) {
						return false;
					}
					
					producto.setCatproductos(categoria);
				}	else if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
					System.out.println("CATEGORIA: "+categoria);
					producto.setCatproductos(categoria);
				}
				
				if (row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
					System.out.println("CODIGO: "+row.getCell(1).getStringCellValue());
					producto.setCodigo(row.getCell(1).getStringCellValue());
				}
				
				if (row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
					System.out.println("NOMBRE: "+row.getCell(2).getStringCellValue());
					producto.setNombre_producto(row.getCell(2).getStringCellValue());

				}
				
				if (row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING) {
					System.out.println("DESCRIPCION: "+row.getCell(3).getStringCellValue());
					producto.setDescripcion(row.getCell(3).getStringCellValue());
				}
				
				if (row.getCell(4).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String stock = NumberToTextConverter.toText(row.getCell(4).getNumericCellValue());
					System.out.println("STOCK: "+stock);
					producto.setStock(Integer.parseInt(stock));
				}	else if (row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
					String stock = NumberToTextConverter.toText(row.getCell(4).getNumericCellValue());
					System.out.println("STOCK: "+stock);
					producto.setStock(Integer.parseInt(stock));
				}
				
				if (row.getCell(5).getCellType() == Cell.CELL_TYPE_NUMERIC) {
					String price = NumberToTextConverter.toText(row.getCell(5).getNumericCellValue());
					System.out.println("PRECIO: "+price);
					producto.setPrecio_compra(Double.parseDouble(price));
				}	else if (row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
					String price = NumberToTextConverter.toText(row.getCell(5).getNumericCellValue());
					System.out.println("PRECIO: "+price);
					producto.setPrecio_compra(Double.parseDouble(price));
				}
				
				producto.setEstado(true);
				productoRepository.save(producto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		return true;
	}


	private Workbook getWorkBook(MultipartFile file) {
		Workbook workbook = null;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		try {
			if (extension.equalsIgnoreCase("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
			} else if (extension.equalsIgnoreCase("xls")){
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return workbook;
	}
}
