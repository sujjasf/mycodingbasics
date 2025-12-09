import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

void main() {
  runApp(EcommerceApp());
}

class EcommerceApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomePage(),
      theme: ThemeData(
        fontFamily: GoogleFonts.poppins().fontFamily,
        scaffoldBackgroundColor: Colors.grey.shade100,
      ),
    );
  }
}

//  Home page
class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  
  int selectedIndex = 1;

  int selectedCategory = 0;

  final List<String> categories = [
    "All",
    "Mobile",
    "Laptops",
    "Watches",
    "Tablets",
    "Accessories",
    "Headphones",
    "Camera",
  ];

  // MAIN PRODUCT LIST
  final List<Map<String, dynamic>> products = [
    {"name": "iPhone 15 Pro", "price": 1299, "img": "product1.png", "category": "Mobile"},
    {"name": "MacBook Air M2", "price": 1499, "img": "product2.jpg", "category": "Laptops"},
    {"name": "Samsung Watch 6", "price": 299, "img": "product3.jpeg", "category": "Watches"},
    {"name": "iPad Pro 12.9", "price": 999, "img": "product4.jpeg", "category": "Tablets"},
    {"name": "Sony Headphones", "price": 199, "img": "product5.jpg", "category": "Headphones"},
    {"name": "Canon DSLR", "price": 899, "img": "product6.jpg", "category": "Camera"},
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          buildTopBar(),
          buildCategoryList(),
          buildProductGrid(),
        ],
      ),
      bottomNavigationBar: buildBottomBar(),
    );
  }

  // ----------------------
  //       TOP BAR
  // ----------------------
  Widget buildTopBar() {
    return Padding(
      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 18),
      child: Row(
        children: [
          Icon(Icons.menu, size: 28),

          Expanded(
            child: Container(
              margin: EdgeInsets.symmetric(horizontal: 16),
              padding: EdgeInsets.symmetric(horizontal: 16),
              height: 45,
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(30),
                boxShadow: [
                  BoxShadow(
                    blurRadius: 6,
                    color: Colors.black12,
                    spreadRadius: 1,
                    offset: Offset(0, 3),
                  ),
                ],
              ),
              child: Row(
                children: [
                  Icon(Icons.search, color: Colors.grey),
                  SizedBox(width: 10),
                  Text(
                    "Search Products....",
                    style: TextStyle(color: Colors.grey, fontSize: 15),
                  ),
                ],
              ),
            ),
          ),

          Icon(Icons.notifications_none, size: 28),
        ],
      ),
    );
  }

  // ----------------------
  //     CATEGORY LIST
  // ----------------------
  Widget buildCategoryList() {
    return Container(
      height: 45,
      margin: EdgeInsets.only(bottom: 10),
      child: ListView.builder(
        scrollDirection: Axis.horizontal,
        itemCount: categories.length,
        padding: EdgeInsets.symmetric(horizontal: 16),
        itemBuilder: (context, index) {
          bool isSelected = selectedCategory == index;

          return GestureDetector(
            onTap: () {
              setState(() {
                selectedCategory = index;
              });
            },
            child: Container(
              margin: EdgeInsets.only(right: 14),
              padding: EdgeInsets.symmetric(horizontal: 20, vertical: 8),
              decoration: BoxDecoration(
                color: isSelected ? Colors.black : Colors.white,
                borderRadius: BorderRadius.circular(20),
                border: Border.all(
                  color: isSelected ? Colors.black : Colors.grey.shade400,
                ),
              ),
              child: Center(
                child: Text(
                  categories[index],
                  style: TextStyle(
                    color: isSelected ? Colors.white : Colors.grey.shade700,
                    fontWeight: isSelected ? FontWeight.bold : FontWeight.w500,
                    fontSize: 13.5,
                  ),
                ),
              ),
            ),
          );
        },
      ),
    );
  }

  // ------------------------
  //     PRODUCT GRID
  // ------------------------
  Widget buildProductGrid() {

    // FILTER LOGIC
    String selectedCategoryName = categories[selectedCategory];

    List filteredProducts = selectedCategoryName == "All"
        ? products
        : products.where((item) => item["category"] == selectedCategoryName).toList();

    return Expanded(
      child: GridView.builder(
        padding: EdgeInsets.all(16),
        itemCount: filteredProducts.length,
        gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
          crossAxisCount: 2,
          childAspectRatio: 0.68,
          crossAxisSpacing: 16,
          mainAxisSpacing: 16,
        ),
        itemBuilder: (context, index) {
          var p = filteredProducts[index];

          return Container(
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(18),
              boxShadow: [
                BoxShadow(
                  blurRadius: 8,
                  spreadRadius: 1,
                  color: Colors.black12,
                ),
              ],
            ),
            child: Column(
              children: [
                Container(
                  height: 130,
                  padding: EdgeInsets.all(12),
                  child: Image.asset(
                    "assets/products/${p['img']}",
                    fit: BoxFit.contain,
                  ),
                ),
                SizedBox(height: 5),

                Text(
                  p["name"],
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 15),
                ),

                SizedBox(height: 6),

                Text(
                  "\$${p['price']}",
                  style: TextStyle(
                    color: Colors.blue,
                    fontSize: 16,
                    fontWeight: FontWeight.w600,
                  ),
                ),

                SizedBox(height: 8),

                Container(
                  height: 38,
                  margin: EdgeInsets.symmetric(horizontal: 12),
                  decoration: BoxDecoration(
                    color: Colors.black,
                    borderRadius: BorderRadius.circular(12),
                  ),
                  child: Center(
                    child: Text(
                      "Add to Cart",
                      style: TextStyle(color: Colors.white, fontSize: 13.5),
                    ),
                  ),
                ),
              ],
            ),
          );
        },
      ),
    );
  }

  // ------------------------
  //    BOTTOM NAV BAR
  // ------------------------
  Widget buildBottomBar() {
    return BottomNavigationBar(
      currentIndex: selectedIndex,
      onTap: (value) {
        setState(() {
          selectedIndex = value;
        });
      },
      type: BottomNavigationBarType.fixed,
      selectedItemColor: Colors.black,
      unselectedItemColor: Colors.grey,
      items: [
        BottomNavigationBarItem(icon: Icon(Icons.favorite), label: "Wishlist"),
        BottomNavigationBarItem(icon: Icon(Icons.apps), label: "Home"),
        BottomNavigationBarItem(icon: Icon(Icons.shopping_cart), label: "Cart"),
        BottomNavigationBarItem(icon: Icon(Icons.person), label: "Profile"),
      ],
    );
  }
}
