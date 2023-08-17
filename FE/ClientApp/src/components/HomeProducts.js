import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import './HomeProduct.css';
import ProductService from '../service/ProductService'
class HomeProducts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            prodarr: [],
            searcharr: [],
            searchtext: ""
        }

    }
    //initialize array 
    componentDidMount() {
        this.fetchdata()
    }

    fetchdata() {
        ProductService.getproducts()
            .then((response) => {
                this.setState({ ...this.state, prodarr: [...response.data], searcharr: [...response.data] })
            }).catch()
    }
    render() {
        return (
            <div className="container pt-5">
                <div className="row">
                    {/* ProductCards */}
                    {this.state.searcharr.map((product) => (
                        <div key={product.id} className="col-lg-3 col-md- col-sm-12 mb-4 d-flex card-hover">
                            <div className="card flex-fill border-0" style={{ background: '#f8f9fa' }}>
                                <div className="bg-image hover-zoom ripple ripple-surface ripple-surface-light" data-mdb-ripple-color="light">
                                    <img src={product.url1} className="w-100" alt={product.proname} style={{ height:150, objectFit: 'contain' }} />
                                    <a href="#!">
                                        <div className="mask">
                                            <div className="d-flex justify-content-start align-items-end h-100">
                                                <h5>
                                                    <span className="badge bg-primary ms-2">New</span>
                                                </h5>
                                            </div>
                                        </div>
                                        <div className="hover-overlay">
                                            <div className="mask" style={{ backgroundColor: 'rgba(251, 251, 251, 0.15)' }}></div>
                                        </div>
                                    </a>
                                </div>
                                <div className="card-body">
                                    <a href="#" className="text-reset" style={{ textDecoration: 'none' }}>
                                        <h5 className="card-title mb-3">{product.proname}</h5>
                                    </a>
                                    <a href="#" className="text-reset" style={{ textDecoration: 'none' }}>
                                        
                                    </a>
                                    <h6 className="mb-3">&#8377; {product.price}</h6>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>



        )
    }
}

export default HomeProducts;