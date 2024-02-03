    package com.mobilneshop.Mobilneshop.mappers;

    import com.mobilneshop.Mobilneshop.DTOMapper;
    import com.mobilneshop.Mobilneshop.DTOs.UserDTO;
    import com.mobilneshop.Mobilneshop.entity.User;
    import com.mobilneshop.Mobilneshop.services.ProductService;
    import com.sun.istack.NotNull;
    import org.springframework.beans.factory.annotation.Autowired;

    import javax.persistence.ElementCollection;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;

    public enum UserMapper implements DTOMapper<User, UserDTO> {
        INSTANCE;

        @Autowired
        private ProductService productService;

        @Override
        public User apply(UserDTO item) {
            User user = new User();
            user.setId(item.getId());
            user.setEmail(item.getEmail());
            user.setAddress(item.getAddress());
            user.setPassword(item.getPassword());
            user.setFavoriteProductIds(item.getFavoriteProductIds());

            return user;
        }
    }




