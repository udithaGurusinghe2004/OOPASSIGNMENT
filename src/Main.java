
import javax.swing.*;
import model.*;
import service.StockManager;
import service.CsvStorage;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();
        String path = "inventory.csv";

        JFrame frame = new JFrame("TRENDFLEX");
        frame.setSize(1080, 720);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // ---- Output area on the right ----
        final JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(220, 30, 820, 620); // x, y, width, height
        frame.add(scrollPane);


        // === Left-side buttons ===
        JButton btnDenim = new JButton("Add Denim");
        btnDenim.setBounds(30, 50, 150, 30);
        frame.add(btnDenim);

        JButton btnShirt = new JButton("Add Shirt");
        btnShirt.setBounds(30, 100, 150, 30);
        frame.add(btnShirt);

        JButton btnTshirt = new JButton("Add Tshirt");
        btnTshirt.setBounds(30, 150, 150, 30);
        frame.add(btnTshirt);

        JButton btnCotton = new JButton("Add CottonTrouser");
        btnCotton.setBounds(30, 200, 150, 30);
        frame.add(btnCotton);

        JButton btnUpdateQty = new JButton("Update Quantity");
        btnUpdateQty.setBounds(30, 250, 150, 30);
        frame.add(btnUpdateQty);

        JButton btnUpdatePrice = new JButton("Update Price");
        btnUpdatePrice.setBounds(30, 300, 150, 30);
        frame.add(btnUpdatePrice);

        JButton btnIncrease = new JButton("Increase Stock");
        btnIncrease.setBounds(30, 350, 150, 30);
        frame.add(btnIncrease);

        JButton btnDecrease = new JButton("Decrease Stock");
        btnDecrease.setBounds(30, 400, 150, 30);
        frame.add(btnDecrease);

        JButton btnRemove = new JButton("Remove Item");
        btnRemove.setBounds(30, 450, 150, 30);
        frame.add(btnRemove);

        JButton btnPrintAll = new JButton("Print All");
        btnPrintAll.setBounds(30, 500, 150, 30);
        frame.add(btnPrintAll);

        JButton btnSaveCSV = new JButton("Save CSV");
        btnSaveCSV.setBounds(30, 550, 150, 30);
        frame.add(btnSaveCSV);

        JButton btnLoadCSV = new JButton("Load CSV");
        btnLoadCSV.setBounds(30, 600, 150, 30);
        frame.add(btnLoadCSV);

        // === Action Listeners ===
        btnDenim.addActionListener(e -> {
            JFrame addFrame = new JFrame("Add Denim");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblName = new JLabel("Name:");
            lblName.setBounds(30, 70, 100, 25);
            JTextField txtName = new JTextField();
            txtName.setBounds(150, 70, 200, 25);

            JLabel lblQty = new JLabel("Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);

            JLabel lblPrice = new JLabel("Price:");
            lblPrice.setBounds(30, 150, 100, 25);
            JTextField txtPrice = new JTextField();
            txtPrice.setBounds(150, 150, 200, 25);

            JLabel lblColor = new JLabel("Color:");
            lblColor.setBounds(30, 190, 100, 25);
            JTextField txtColor = new JTextField();
            txtColor.setBounds(150, 190, 200, 25);

            JLabel lblSize = new JLabel("Size:");
            lblSize.setBounds(30, 230, 100, 25);
            JTextField txtSize = new JTextField();
            txtSize.setBounds(150, 230, 200, 25);

            JLabel lblFit = new JLabel("Fit/Regular:");
            lblFit.setBounds(30, 270, 100, 25);
            JTextField txtFit = new JTextField();
            txtFit.setBounds(150, 270, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblName); 
            addFrame.add(txtName);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(lblPrice); 
            addFrame.add(txtPrice);
            addFrame.add(lblColor); 
            addFrame.add(txtColor);
            addFrame.add(lblSize); 
            addFrame.add(txtSize);
            addFrame.add(lblFit); 
            addFrame.add(txtFit);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                String name = txtName.getText();
                int qty = Integer.parseInt(txtQty.getText());
                double price = Double.parseDouble(txtPrice.getText());
                String color = txtColor.getText();
                String size = txtSize.getText();
                String fit = txtFit.getText();

                boolean ok = manager.add(new Denim(id, name, qty, price, color, size, fit));
                System.out.println("Added Denim: " + ok);
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnShirt.addActionListener(e -> {
            JFrame addFrame = new JFrame("Add Shirt");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblName = new JLabel("Name:");
            lblName.setBounds(30, 70, 100, 25);
            JTextField txtName = new JTextField();
            txtName.setBounds(150, 70, 200, 25);

            JLabel lblQty = new JLabel("Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);

            JLabel lblPrice = new JLabel("Price:");
            lblPrice.setBounds(30, 150, 100, 25);
            JTextField txtPrice = new JTextField();
            txtPrice.setBounds(150, 150, 200, 25);

            JLabel lblColor = new JLabel("Color:");
            lblColor.setBounds(30, 190, 100, 25);
            JTextField txtColor = new JTextField();
            txtColor.setBounds(150, 190, 200, 25);

            JLabel lblSize = new JLabel("Size:");
            lblSize.setBounds(30, 230, 100, 25);
            JTextField txtSize = new JTextField();
            txtSize.setBounds(150, 230, 200, 25);

            JLabel lblFit = new JLabel("short/long sleeve:");
            lblFit.setBounds(30, 270, 100, 25);
            JTextField txtFit = new JTextField();
            txtFit.setBounds(150, 270, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblName); 
            addFrame.add(txtName);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(lblPrice); 
            addFrame.add(txtPrice);
            addFrame.add(lblColor); 
            addFrame.add(txtColor);
            addFrame.add(lblSize); 
            addFrame.add(txtSize);
            addFrame.add(lblFit); 
            addFrame.add(txtFit);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                String name = txtName.getText();
                int qty = Integer.parseInt(txtQty.getText());
                double price = Double.parseDouble(txtPrice.getText());
                String color = txtColor.getText();
                String size = txtSize.getText();
                String fit = txtFit.getText();

                boolean ok = manager.add(new Shirt(id, name, qty, price, color, size, fit));
                System.out.println("Added Denim: " + ok);
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnTshirt.addActionListener(e -> {
            JFrame addFrame = new JFrame("Add T-Shirt");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblName = new JLabel("Name:");
            lblName.setBounds(30, 70, 100, 25);
            JTextField txtName = new JTextField();
            txtName.setBounds(150, 70, 200, 25);

            JLabel lblQty = new JLabel("Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);

            JLabel lblPrice = new JLabel("Price:");
            lblPrice.setBounds(30, 150, 100, 25);
            JTextField txtPrice = new JTextField();
            txtPrice.setBounds(150, 150, 200, 25);

            JLabel lblColor = new JLabel("Color:");
            lblColor.setBounds(30, 190, 100, 25);
            JTextField txtColor = new JTextField();
            txtColor.setBounds(150, 190, 200, 25);

            JLabel lblSize = new JLabel("Size:");
            lblSize.setBounds(30, 230, 100, 25);
            JTextField txtSize = new JTextField();
            txtSize.setBounds(150, 230, 200, 25);

            JLabel lblFit = new JLabel("short/long sleeve");
            lblFit.setBounds(30, 270, 100, 25);
            JTextField txtFit = new JTextField();
            txtFit.setBounds(150, 270, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblName); 
            addFrame.add(txtName);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(lblPrice); 
            addFrame.add(txtPrice);
            addFrame.add(lblColor); 
            addFrame.add(txtColor);
            addFrame.add(lblSize); 
            addFrame.add(txtSize);
            addFrame.add(lblFit); 
            addFrame.add(txtFit);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                String name = txtName.getText();
                int qty = Integer.parseInt(txtQty.getText());
                double price = Double.parseDouble(txtPrice.getText());
                String color = txtColor.getText();
                String size = txtSize.getText();
                String fit = txtFit.getText();

                boolean ok = manager.add(new Tshirt(id, name, qty, price, color, size, fit));
                System.out.println("Added Denim: " + ok);
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnCotton.addActionListener(e -> {
            JFrame addFrame = new JFrame("Add  CottonTrouser");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblName = new JLabel("Name:");
            lblName.setBounds(30, 70, 100, 25);
            JTextField txtName = new JTextField();
            txtName.setBounds(150, 70, 200, 25);

            JLabel lblQty = new JLabel("Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);

            JLabel lblPrice = new JLabel("Price:");
            lblPrice.setBounds(30, 150, 100, 25);
            JTextField txtPrice = new JTextField();
            txtPrice.setBounds(150, 150, 200, 25);

            JLabel lblColor = new JLabel("Color:");
            lblColor.setBounds(30, 190, 100, 25);
            JTextField txtColor = new JTextField();
            txtColor.setBounds(150, 190, 200, 25);

            JLabel lblSize = new JLabel("Size:");
            lblSize.setBounds(30, 230, 100, 25);
            JTextField txtSize = new JTextField();
            txtSize.setBounds(150, 230, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblName); 
            addFrame.add(txtName);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(lblPrice); 
            addFrame.add(txtPrice);
            addFrame.add(lblColor); 
            addFrame.add(txtColor);
            addFrame.add(lblSize); 
            addFrame.add(txtSize);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                String name = txtName.getText();
                int qty = Integer.parseInt(txtQty.getText());
                double price = Double.parseDouble(txtPrice.getText());
                String color = txtColor.getText();
                String size = txtSize.getText();

                boolean ok = manager.add(new CottonTrouser(id, name, qty, price, color, size));
                System.out.println("Added Denim: " + ok);
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnUpdateQty.addActionListener(e -> {
            JFrame addFrame = new JFrame("Update Quentity");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

           
            JLabel lblQty = new JLabel("Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);


            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                int newqty = Integer.parseInt(txtQty.getText());

                System.out.println("Updated qty: " + manager.updateQuantity(id, newqty));
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnUpdatePrice.addActionListener(e -> {
            JFrame addFrame = new JFrame("Update the price ");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblPrice = new JLabel("Price:");
            lblPrice.setBounds(30, 150, 100, 25);
            JTextField txtPrice = new JTextField();
            txtPrice.setBounds(150, 150, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblPrice); 
            addFrame.add(txtPrice);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                double newprice = Double.parseDouble(txtPrice.getText());

                System.out.println("Updated price: " + manager.updatePrice(id, newprice));
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnIncrease.addActionListener(e -> {
            JFrame addFrame = new JFrame("Increse Quantity");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblQty = new JLabel("increse Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                int delta = Integer.parseInt(txtQty.getText());

                System.out.println("Increase: " + manager.increaseStock(id, delta));
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnDecrease.addActionListener(e -> {
            JFrame addFrame = new JFrame("Increse Quantity");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JLabel lblQty = new JLabel("increse Quantity:");
            lblQty.setBounds(30, 110, 100, 25);
            JTextField txtQty = new JTextField();
            txtQty.setBounds(150, 110, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(lblQty); 
            addFrame.add(txtQty);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                int delta = Integer.parseInt(txtQty.getText());

                System.out.println("Decrease: " + manager.decreaseStock(id, delta));
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnRemove.addActionListener(e -> {
            JFrame addFrame = new JFrame("Remove Item");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("ID:");
            lblId.setBounds(30, 30, 100, 25);
            JTextField txtId = new JTextField();
            txtId.setBounds(150, 30, 200, 25);

            JButton btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(txtId);
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                String id = txtId.getText();
                
                System.out.println("Removed: " + manager.remove(id));
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });

        btnSaveCSV.addActionListener(e -> {
            JFrame addFrame = new JFrame("Save Item");
            addFrame.setSize(400, 400);
            addFrame.setLayout(null);

            JLabel lblId = new JLabel("Click below button to confirm the save");
            lblId.setBounds(100, 50, 400, 200);

            JButton btnSubmit = new JButton("SAVE");
            btnSubmit.setBounds(150, 320, 100, 30);

            addFrame.add(lblId); 
            addFrame.add(btnSubmit);

            btnSubmit.addActionListener(ev -> {
                
                boolean ok = CsvStorage.save(path, manager.listAll());
                System.out.println("Saved to " + path + ": " + ok);
                addFrame.dispose();
            });

            addFrame.setVisible(true);
        });
        
        
    btnPrintAll.addActionListener(e -> {
    StringBuilder sb = new StringBuilder();
    for (var item : manager.listAll()) {
        sb.append(item.toString()).append("/n  "); // simple format; relies on each model's toString()
    }
    outputArea.setText(sb.toString());
    outputArea.setCaretPosition(0); //position make to top
});


        btnLoadCSV.addActionListener(e -> {
            manager.clear();
            CsvStorage.load(path).forEach(manager::add);
            System.out.println("Loaded from " + path);
        });

        frame.setVisible(true);
    
    
}
}

