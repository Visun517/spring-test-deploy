package lk.ijse.gdse71.spring_testing;

import lk.ijse.gdse71.spring_testing.entity.Product;
import lk.ijse.gdse71.spring_testing.repo.ProductRepository;
import lk.ijse.gdse71.spring_testing.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;
    private Product product;

    @BeforeEach
    public void setUp() {
        product = Product.builder()
                .id(1L)
                .name("Test Product")
                .price(100.0)
                .quantity(10)
                .build();

    }

    @Test
    void shouldSaveProduct() {
        //01. data arrange
        when(productRepository.save(any(Product.class))).thenReturn(product);

        //02. action
        Product savedProduct = productService.createProduct(product);

        //03. assert
        Assertions.assertNotNull(savedProduct);
        Assertions.assertEquals(product.getId(), savedProduct.getId());
        verify(productRepository,times(1)).save(any(Product.class));

        // test ekkk liynd vidi
    }

    @Test
    void shouldUpdateProduct() {

        Product product = Product.builder()
                .id(1L)
                .name("Updated Product")
                .price(150.0)
                .quantity(20)
                .build();

        //01. dat arrange
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);

        //02. action
        Product updatedProduct = productService.updateProduct(product);

        //03. assert
        Assertions.assertNotNull(updatedProduct);
        Assertions.assertEquals(product.getId(), updatedProduct.getId());
        Assertions.assertEquals("Updated Product", updatedProduct.getName());
        Assertions.assertEquals(150.0, updatedProduct.getPrice());
        Assertions.assertEquals(20, updatedProduct.getQuantity());

        verify(productRepository, times(1)).save(any(Product.class));

    }

    @Test
    void shouldGetAllProduct(){
        //01. dat arrange
        when(productRepository.findAll()).thenReturn(
                List.of(product)
        );

        //02. action
        List<Product> products = productService.getAllProducts();

        //03. assert
        Assertions.assertNotNull(products);
        Assertions.assertEquals(1, products.size());

       verify(productRepository, times(1)).findAll();
    }
}
