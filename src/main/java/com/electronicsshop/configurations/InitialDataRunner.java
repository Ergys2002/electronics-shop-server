package com.electronicsshop.configurations;

import com.electronicsshop.entities.Category;
import com.electronicsshop.entities.Product;
import com.electronicsshop.repositories.ICategoryRepository;
import com.electronicsshop.repositories.IProductRepository;
import com.electronicsshop.services.ICategoryService;
import com.electronicsshop.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor

public class InitialDataRunner implements CommandLineRunner {

    protected final IProductRepository productRepository;

    protected final ICategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    public void seedData(){

        Category laptop = createCategoryIfNotPresent("Laptop");
        Category mobilePhone = createCategoryIfNotPresent("Mobile Phone");
        Category tablet = createCategoryIfNotPresent("Tablet");
        Category tv = createCategoryIfNotPresent("TV");


        createProductIfNotPresent(
                "Iphone 14 Pro Max",
                1400,
                true,
                1350,
                0,
                100,
                3,
                "Released 2022, September 16\n" +
                "240g, 7.9mm thickness\n" +
                "iOS 16, up to iOS 16.5\n" +
                "128GB/256GB/1TB storage, no card slot\n",
                "iphone-14-pro-max-banner.jpg",
                "iphone-14-pro-max-photo.jpeg",
                mobilePhone.getId());

        createProductIfNotPresent(
                "Samsung Galaxy S22 Ultra",
                1200,
                false,
                1200,
                0,
                100,
                1,
                "Released 2022, February 25\n" +
                        "228g / 229g (mmWave), 8.9mm thickness\n" +
                        "Android 12, up to Android 13, One UI 5.1\n" +
                        "128GB/256GB/1TB storage, no card slot",
                "samsung-galaxy-s22-ultra-banner.jpeg",
                "samsung-galaxy-s22-ultra-photo.jpg",
                mobilePhone.getId());

        createProductIfNotPresent(
                "Asus Rog Zephyrus G16 Duo",
                2500,
                true,
                2300,
                0,
                100,
                5,
                "Reaching new heights of innovation for dual-display laptops," +
                        " ROG Zephyrus Duo 16 paves the way to fresh and exciting experiences" +
                        " for gamers and creators. But the innovation doesn’t end with ASUS" +
                        " ScreenPad Plus, this incredible device also features other innovations" +
                        " like a Nebula HDR display, ROG Intelligent Cooling, AI Noise Cancelation and more.",
                "asus-rog-zephyrus-g16-duo-banner.jpg",
                "asus-rog-zephyrus-g16-duo-photo.png",
                laptop.getId());

        createProductIfNotPresent(
                "Samsung Galaxy S23 Ultra",
                1600,
                true,
                1400,
                0,
                100,
                5,
                "Released 2023, February 17\n" +
                        "234g, 8.9mm thickness\n" +
                        "Android 13, One UI 5.1\n" +
                        "256GB/512GB/1TB storage, no card slot",
                "samsung-galaxy-s23-ultra-banner.jpeg",
                "samsung-galaxy-s23-ultra-photo.jpg",
                mobilePhone.getId());

        createProductIfNotPresent(
                "Asus TUF Dash F15",
                1500,
                false,
                1500,
                0,
                100,
                5,
                "Latest 12th Gen Intel® Core™ CPU and a RTX 30 Series Laptop GPU with MUX switch" +
                        "Meets MIL-STD-810H standard, Type-C charging support and a long-lasting battery in a 19.95mm slim chassis" +
                        "QHD 165Hz or FHD 300Hz with Adaptive Sync support",
                "asus-tuf-dash-f15-banner.jpeg",
                "asus-tuf-dash-f15-photo.jpeg",
                laptop.getId());

        createProductIfNotPresent(
                "Dell Alienware x17",
                3750,
                true,
                3500,
                0,
                100,
                2,
                "12th Gen Intel® Core™ i7-12700H (24 MB cache, 14 cores, 20 threads, up to 4.70 GHz Turbo)",
                "dell-alienware-x17-banner.jpeg",
                "dell-alienware-x17-photo.png",
                laptop.getId());

        createProductIfNotPresent(
                "Macbook Air M2",
                6500,
                true,
                6300,
                0,
                100,
                4,
                "Apple MacBook Pro 16.2\" with Liquid Retina XDR Display, M2 Max Chip with 12-Core CPU and 38-Core GPU, 96GB Memory, 8TB SSD, Space Gray, Early 2023",
                "macbook-air-m2-banner.jpeg",
                "macbook-air-m2-photo.png",
                laptop.getId());

        createProductIfNotPresent(
                "Apple iPad 10",
                600,
                false,
                600,
                0,
                100,
                5,
                "The all-new iPad is colorfully reimagined to be more capable, more intuitive, and even more fun. With a new all‑screen design, 10.9-inch Liquid Retina display, and four gorgeous colors, iPad delivers a powerful way to get things done, create, and stay connected.1 Add on essential accessories designed just for iPad and enjoy endless versatility for everything you love to do.",
                "ipad-10-banner.jpeg",
                "ipad-10-photo.jpeg",
                tablet.getId());

        createProductIfNotPresent(
                "Samsung S95C OLED TV",
                5000,
                false,
                5000,
                0,
                100,
                4,
                "The future of Samsung OLED, brighter than ever before\n" +
                        "Turn every seat in the house into the best seat with the bold contrast, dramatic sound and vibrant colors that are 30% brighter boosted by tiny Quantum Dots**. Watch as ordinary content is transformed into mesmerizing colorful 4K pictures thanks to powerful AI processing technology. The powerful Dolby Atmos audio will put you in the action.",
                "samsung-s95c-banner.jpeg",
                "samsung-s95c-photo.jpg",
                tv.getId());



    }

    public void createProductIfNotPresent(String title, double price, boolean sale, double salePrice,int totalSales, int stock, int rating, String description, String banner, String photo, UUID categoryId) {

        Product firstProduct = Product.builder()
                .title(title)
                .price(price)
                .sale(sale)
                .salePrice(salePrice)
                .totalSales(totalSales)
                .stock(stock)
                .description(description)
                .rating(rating)
                .banner(banner)
                .photo(photo)
                .categoryId(categoryId)
                .build();

        Optional<Product> productDb = productRepository.findByTitleEqualsIgnoreCase(firstProduct.getTitle());
        if (productDb.isEmpty())
            firstProduct = productRepository.save(firstProduct);
        else firstProduct = productDb.get();

    }

    public Category createCategoryIfNotPresent(String title){
        Category firstCategory = Category.builder()
                .title(title)
                .build();

        Optional<Category> categoryDb = categoryRepository.findByTitleEqualsIgnoreCase(firstCategory.getTitle());
        if (categoryDb.isEmpty())
            firstCategory = categoryRepository.save(firstCategory);
        else firstCategory = categoryDb.get();

        return firstCategory;
    }




}
