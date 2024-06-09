import React, { useState,useEffect } from 'react';
import axios from 'axios';
import FrCard from '../components/frCard.jsx';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Pagination from '@mui/material/Pagination';
import TextField from '@mui/material/TextField';
import { Typography } from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import FormLabel from '@mui/material/FormLabel';
import FormControl from '@mui/material/FormControl';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormHelperText from '@mui/material/FormHelperText';
import Checkbox from '@mui/material/Checkbox';
import Button from '@mui/material/Button';
import AddCircleIcon from '@mui/icons-material/AddCircle'; // 
import '../App.css';
import ResponsiveAppBar from '../components/navbar';
import AddForm from '../components/AddForm.jsx';

const FrContent = () => {
  {/*const theme = createTheme({
    palette: {
      primary: '#ae4459',
      secondary: '#f39f5a',
    },
  });*/}
  
  const [page, setPage] = React.useState(1);
  const [itemsPerPage] = React.useState(12);
  const [nbProd, setNbProd] = useState(0);
  const [minPrix, setMinPrix] = useState('');
  const [maxPrix, setMaxPrix] = useState('');
  const currentDate = new Date().toISOString().split('T')[0]; // Get current date in "yyyy-MM-dd" format

const [debDate, setDebDate] = useState(currentDate);
const [finDate, setFinDate] = useState(currentDate);
  const [produits, setProduits] = useState([]);
  const fournisseurId = localStorage.getItem('fournisseurId');
  const [searchQuery, setSearchQuery] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  

  const [open, setOpen] = useState(false); // State for modal visibility

  const handleClickOpen = () => {
    setOpen(true); // Open the modal on button click
  };

  const handleClose = () => {
    setOpen(false); // Close the modal
  };

  
  

// GET TOUS LES PRODUITS DU FOURNISSEUR LOGGE
 // Fetch all products
const fetchData = async () => {
  if (fournisseurId) {
      try {
          const response = await axios.get(`http://localhost:8092/Produits/fournisseur/produits/${fournisseurId}`);
          setProduits(response.data);
          setNbProd(response.data.length); // Set the number of products
          console.log('Récupération réussie!');
      } catch (error) {
          console.error('Erreur lors de la récupération des données:', error);
      }
  }
};

React.useEffect(() => {
  fetchData();
}, [fournisseurId]);

// Filter by price
const filtre_prixPro = () => {
  const filtered = produits.filter(produit => produit.prix >= minPrix && produit.prix <= maxPrix);
  setProduits(filtered);
};

// Filter by date
const filtre_datePro = () => {
  const filtered = produits.filter(produit => {
      const dateAjout = new Date(produit.dateAjout);
      return dateAjout >= new Date(debDate) && dateAjout <= new Date(finDate);
  });
  setProduits(filtered);
};

// Filter by search query
/*const handleSearch = () => {
  const filtered = produits.filter(produit =>
      produit.nom.toLowerCase().includes(searchQuery.toLowerCase())
  );
  setProduits(filtered);
};
*/
// Sorting functions
const filtre_idProDesc = () => {
  const sorted = [...produits].sort((a, b) => b.idPro - a.idPro);
  setProduits(sorted);
};

const filtre_designProAsc = () => {
  const sorted = [...produits].sort((a, b) => a.design.localeCompare(b.design));
  setProduits(sorted);
};

const filtre_designProDesc = () => {
  const sorted = [...produits].sort((a, b) => b.design.localeCompare(a.design));
  setProduits(sorted);
};

const handleChange = (event, value) => {
  setPage(value);
};

const paginate = (array, page_size, page_number) => {
  return array.slice((page_number - 1) * page_size, page_number * page_size);
};

React.useEffect(() => {
  let timer;
  if (minPrix !== '' && maxPrix !== '') {
      timer = setTimeout(() => {
          filtre_prixPro();
      }, 500);
  }
  return () => clearTimeout(timer);
}, [minPrix, maxPrix]);

React.useEffect(() => {
  if (debDate !== '' && finDate !== '') {
      filtre_datePro();
  }
}, [debDate, finDate]);
  


  // ***** RECHERCHE ********** 
  const handleSearch = async () => {
    if (fournisseurId) {
    try {
      const response = await axios.get(`http://localhost:8092/Produits/search/${searchQuery}/${fournisseurId}`); // Adjust URL as needed
      setProduits(response.data);
    } catch (error) {
      console.error('Error searching products:', error);
    }
  }
  };
  
  return (
    <>
    <ResponsiveAppBar onSearch={handleSearch} setSearchQuery={setSearchQuery} />
    <div className="englobe">
   
    <div className="cotegauche">
    <h3 className="tfiltre">Filtrer la liste </h3>
    <div className='filt' onClick={filtre_idProDesc}>
    <Typography variant="p" component="div">
      Plus recent
    </Typography>
  </div>
  <div className='filt' onClick={filtre_designProAsc}>
    <Typography variant="p" component="div">
      Ordre croissant (A-Z)
    </Typography>
  </div>
  <div className='filt' onClick={filtre_designProDesc}>
    <Typography variant="p" component="div">
      Ordre decroissant (Z-A)
    </Typography>
  </div>
  <div className='filtVal'>
    <p>Selon les prix</p>
    <div className="delprix">
    <TextField
            label="min"
            type="number"
           
            margin="normal"
            variant="outlined"
            value={minPrix}
            onChange={(e) => setMinPrix(e.target.value)}
            
            sx={{margin:"10px"}}
          />
          <TextField
            label="max"
            type="number"
            
            margin="normal"
            variant="outlined"
            value={maxPrix}
            onChange={(e) => setMaxPrix(e.target.value)}
            sx={{margin:"10px",height:"20px"}}
          />
      
    </div>
  </div>
  <div className='filtVal'>
                    <p>Selon les dates d'ajout</p>
                    <div className="deldate">
                        <input type="date" className="debdate" onChange={(e) => setDebDate(e.target.value)} /><label htmlFor="">debut</label><br />
                        <input type="date" className="findate" onChange={(e) => setFinDate(e.target.value)} /><label htmlFor="">fin</label>
                    </div>
                </div>
  </div>
    <div className="cotedroite">
    
    <Container>
    
      <Stack
        direction="row"
        justifyContent="space-between"
        alignItems="flex-start"
        spacing={2}
      >
              <h4 className='frProd_titre'>Produits mise en marche: {nbProd} </h4>
              <Button variant="contained" startIcon={<AddCircleIcon />} onClick={handleClickOpen} sx={{marginLeft:"100px",backgroundColor:'rgba(255,184,27,0.85)', '&:hover': {
    backgroundColor: 'white',
    color:'#ffad64',
  },}}>
            Ajouter
          </Button>
          </Stack>
          <Grid container spacing={3} sx={{ marginTop: '25px' }}>
                        {paginate(produits, itemsPerPage, page).map(produit => (
                            <FrCard key={produit.idPro} produit={produit} />
                        ))}
                    </Grid>
                    <Box sx={{ padding: '10px', marginTop: '50px', marginLeft: '20%', width: '50%', justifyContent: 'center', alignItems: 'center' }}>
                        <Stack spacing={2} direction='row'>
                            <Typography>Page: {page}</Typography>
                            <Pagination
                                count={Math.ceil(nbProd / itemsPerPage)}
                                page={page}
                                onChange={handleChange}
                                sx={{ color: 'darkslategrey' }}
                            />
                        </Stack>
                    </Box>
        
        </Container>
        <AddForm open={open} onClose={handleClose} />
        </div>
       
 </div>
 </>
  );
}

export default FrContent;

/**
 * const filtre_idProDesc = async () =>{
    
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/Produits/produitsIdDesc/${fournisseurId}`);
        setProduits(response.data);
        
      } catch (error) {
        console.error('Erreur pour le filtre du produit plus recent:', error);
      }
    }

  }
  const filtre_designProAsc = async () =>{
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/Produits/produitsDesignAsc/${fournisseurId}`);
        setProduits(response.data);
      } catch (error) {
        console.error('Erreur pour filtre nom du produit asc:', error);
      }
    }
    
  }
  const filtre_designProDesc = async () =>{
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/Produits/produitsDesignDesc/${fournisseurId}`);
        setProduits(response.data);
      } catch (error) {
        console.error('Erreur pour filtre nom du produit desc:', error);
      }
    }
    
  }
  const filtre_prixPro = async () =>{
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/Produits/produitsFiltre2Prix/${minPrix}/${maxPrix}/${fournisseurId}`);
        setProduits(response.data);
      } catch (error) {
        console.error('Erreur pour filtre produit par prix:', error);
      }
    }
    
  }
  const filtre_datePro = async () =>{
    if (fournisseurId) {
      try {
        const response = await axios.get(`http://localhost:8092/Produits/produitsFiltre2Dates/${debDate}/${finDate}/${fournisseurId}`);
        setProduits(response.data);
      } catch (error) {
        console.error('Erreur pour filtre produit par prix:', error);
      }
    }
    
  }

  useEffect(() => {
    let timer;
    if (minPrix !== '' && maxPrix !== '') {
      timer = setTimeout(() => {
        filtre_prixPro();
      },5000);
      
    }

    return() => clearTimeout(timer);
    }, [minPrix, maxPrix]);

  useEffect(() => {
    if (debDate !== '' && finDate !== '') {
      filtre_datePro();
    }
  }, [debDate, finDate]);

 */