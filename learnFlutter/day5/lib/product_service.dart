import 'package:dio/dio.dart';

class ProductService {
  final Dio _dio = Dio();
  final String _baseUrl = 'https://fakestoreapi.com';

  Future<List<dynamic>> fetchProducts() async {
    try {
      final response = await _dio.get('$_baseUrl/products');
      print(response.data);
      return response.data;
    } catch (e) {
      print('Error: $e');
      rethrow;
    }
  }
}
