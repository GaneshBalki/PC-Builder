import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useDistributor } from './DistributorContext';
import DistributorService from '../../service/DistributorService';

const DistributorHome = () => {
    const [products, setProducts] = useState([]);
    const [distributorInfo, setDistributorInfo] = useState(null);
    const { setDisid } = useDistributor();

    const { disid } = useDistributor();
    const [newProduct, setNewProduct] = useState({
        name: '',
        description: '',
        price: 0,
    });

    React.useEffect(() => {
        DistributorService.getDistributorById(disid)
            .then((response) => {
                setDistributorInfo(response.data);
            })
            .catch((error) => {
                console.error(error);
            });
    }, [disid]);


    useEffect(() => {
        const storedDisid = sessionStorage.getItem('disid');
        if (storedDisid !== null) {
            const disidNumber = parseInt(storedDisid, 10); // Convert back to a number
            setDisid(disidNumber);

            console.log('Customer ID:', disidNumber);
        } else {
            console.log('Customer ID not found in sessionStorage.');
        }

    }, []);

    useEffect(() => {

        DistributorService.getDistributorProducts(disid)
            .then((response) => {
                setProducts([...response.data]);
            })
            .catch((error) => {
                console.error('Error fetching products:', error);
            });
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setNewProduct({ ...newProduct, [name]: value });
    };

    const handleAddProduct = () => {
        // // Make a POST request to add the new product
        // axios.post('http://your-api-url.com/distributor/products/add', newProduct)
        //   .then((response) => {
        //     // Refresh the list of products
        //     setProducts([...products, response.data]);
        //     // Clear the input fields
        //     setNewProduct({ name: '', description: '', price: 0 });
        //   })
        //   .catch((error) => {
        //     console.error('Error adding product:', error);
        //   });
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-12">
                    <div className="distributor-profile" style={{ display: 'flex', alignItems: 'flex-start' }}>
                        {distributorInfo ? (
                            <h3>{distributorInfo.disname}</h3>
                        ) : (
                            <p>Loading distributor info...</p>
                        )}
                    </div>
                </div>
            </div>

            <div className="row">
                <div className="col-md-8">
                    <h2>Your Products</h2>
                    <ul>
                        {products.map((product) => (
                            <li key={product.id}>
                                <h3>{product.name}</h3>
                                <p>{product.description}</p>
                                <p>Price: ${product.price}</p>
                            </li>
                        ))}
                    </ul>
                </div>
                {/*  <div className="col-md-4">
                    <h2>Add a New Product</h2>
                    <div className="form-group">
                        <label>Name:</label>
                        <input
                            type="text"
                            name="name"
                            className="form-control"
                            value={newProduct.name}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Description:</label>
                        <input
                            type="text"
                            name="description"
                            className="form-control"
                            value={newProduct.description}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Price:</label>
                        <input
                            type="number"
                            name="price"
                            className="form-control"
                            value={newProduct.price}
                            onChange={handleChange}
                        />
                    </div>
                    <button className="btn btn-primary" onClick={handleAddProduct}>
                        Add Product
                    </button>
                </div> */}
            </div>
        </div>
    );
};

export default DistributorHome;
