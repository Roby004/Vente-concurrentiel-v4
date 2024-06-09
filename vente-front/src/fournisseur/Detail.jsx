import React, { useState, useEffect } from 'react';

import FrCardVert from '../components/frCardVert.jsx';
import Container from '@mui/material/Container';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import Pagination from '@mui/material/Pagination';
import Rating from '@mui/material/Rating';
import Button from '@mui/material/Button';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import StarIcon from '@mui/icons-material/Star';
import DeleteIcon from '@mui/icons-material/Delete';
import BorderColorIcon from '@mui/icons-material/BorderColor';
import SuppForm from '../components/SuppForm.jsx';
import ModifForm from '../components/ModifForm.jsx';
import Typography from '@mui/material/Typography';
import ResponsiveAppBar from '../components/navbar';
import AddForm from '../components/AddForm.jsx';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import Divider from '@mui/material/Divider';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import Avatar from '@mui/material/Avatar';
import { useParams } from 'react-router-dom';
import axios from 'axios';
{/* import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css'; */}

const labelStar = {
  0.5: 'tres mauvais',
  1: 'mauvais',
  1.5: 'mediocre',
  2: 'insatisfaisant',
  2.5: 'passable',
  3: 'Ok',
  3.5: 'bien',
  4: 'tres bien',
  4.5: 'Excellent',
  5: 'Exceptionnel',
};
const Detail = () =>{
  const {idPro} = useParams();
  const [page, setPage] = React.useState(1);
  const [sumVotes, setSumVotes] = React.useState(0);
  const [produit, setProduit] = useState([]);
  const [avis, setAvis] = useState([]);
  const [avisList, setAvisList] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);
 

  
  const handleChange = (event, value) => {
    setPage(value);
  };
    const [openDel, setOpenDel] = useState(false);
    const [openMod, setOpenMod] = useState(false); // State for modal visibility

  const handleDelete = () => {
    setOpenDel(true); // Open the delete
  };
  const handleModif = () => {
    setOpenMod(true); // Open the modif
  };
  const handleModifClose = () => {
    setOpenMod(false); 
   // Close modif
  };
  const handleClose = () => {
    setOpenDel(false); 
   // Close delete
  };
  
  console.log('test console log avant getProduit', idPro);

  useEffect(() => {
    const getProduit = async () => {
      console.log('test console log pendant getProduit', idPro);
      try {
        const response = await axios.get(`http://localhost:8092/Produits/getUnProduit/${idPro}`);
        setProduit(response.data);
        console.log('Récupération réussie!',response.data);
      } catch (error) {
        console.error('Erreur lors de la récupération des données:', error);
      }
    };

    getProduit();
  }, [idPro]);


  /*const getAvis = async () => {
    if (idPro) {
        try {
            const response = await axios.get(`http://localhost:8080/avis/avisParProduit/${idPro}`);
            setAvis(response.data);
            //setSumVotes(response.data);
            console.log('votes:', response.data);
            console.log('liste commentaires:', response.data.sumVotes);
        } catch (error) {
            console.error('Erreur sur recup avis:', error);
        }
    }
};
useEffect(() => {
    getAvis();
}, [idPro]);*/


useEffect(() => {
  const fetchAvis = async () => {
    setIsLoading(true);
    setError(null);

    try {
      const response = await axios.get(`http://localhost:8092/avis/avisParProduit/${idPro}`);
      setAvisList(response.data);
      console.log("retour sur liste avis :", response.data);
    } catch (error) {
      console.error('Error fetching avis:', error);
      setError(error.message || 'An error occurred while fetching avis.');
    } finally {
      setIsLoading(false);
    }
  };
  fetchAvis();
}, [idPro]);


console.log('avisList before map:', avisList);
 
  {/*const getAvis = async () => {
   // const produitId = localStorage.getItem('idPro');
    if (produit.idPro) {
      try {
        const response = await axios.get(`http://localhost:8092/avis/${idPro}`);
        setAvis(response.data); 
      } catch (error) {
        console.error('Erreur sur recup avis:', error);
      }
    }
  };
  React.useEffect(() => {

    getAvis(); 
  }, []); */}
  const value = 4;
    return (
        <>
        < ResponsiveAppBar/>

        <Stack direction='row' sx={{marginTop:'70px'}}>
            <Box
            sx={{ width: '25%',margin: 'auto',marginTop:'70px', padding:'10px' }}
            > 
              <img src={`data:image/*;base64,${produit.imgPro}`} alt={produit.design} width="350px"/>
              <Paper elevation={1} sx={{padding:'15px',marginTop:'50px'}}>
              <Box sx={{ width: 200, display: 'flex', alignItems: 'center' }}>
            <Rating
                name="text-feedback"
                value={sumVotes / avis.length}
                readOnly
                precision={0.5}
                emptyIcon={<StarIcon style={{ opacity: 0.55 }} fontSize="inherit" />}
            />
            <Box sx={{ ml: 2 }}>{labelStar[sumVotes / avis.length]}</Box>
        </Box>
              </Paper>
              </Box>
            <Stack spacing={2} sx={{marginLeft:'10px',marginRight:'60px',marginTop:"20px", padding:'60px',maxWidth:'700px',backgroundColor:'white'}}>
            <Stack spacing={{ xs: 1, sm: 2 }} direction="row" useFlexGap flexWrap="wrap" sx={{justifyContent: 'space-between'}}>
            <Typography gutterBottom variant="h4" component="div" >
                {produit.design}
            </Typography>
            <Box sx={{justifyContent: 'flex-end', textAlign: 'right', marginTop:'-10px'}}>
                <Button variant="contained" onClick={handleDelete} sx={{background: 'linear-gradient(90deg, #FA9372 0%, rgba(210, 37, 37, 0.869) 100%)',margin:'10px', borderRadius: 1,border: 0,color: 'white',height: 40,}}>
                <DeleteIcon />
                </Button>
                <Button variant="contained" onClick={handleModif} sx={{background: 'linear-gradient(90deg, #613159 0%, #1d1a35 100%)',borderRadius: 1,border: 0,color: 'white',height: 40,}}> {/*backgroundColor:'#1D1A39',*/}
                <BorderColorIcon />
                </Button>
            </Box>
            </Stack>
            <Typography gutterBottom variant="subtitle2" component="div" sx={{fontSize:'17px'}}>
            <strong>Stock:</strong> {produit.qte}
            </Typography>
            <Typography variant="h5" component="div" sx={{fontSize:'17px'}}>
            <strong>Categorie:</strong> {produit.categorie}
      </Typography>
      <Typography variant="h5" component="div" sx={{fontSize:'17px'}}>
       <strong>Prix:</strong> {produit.prix}
      </Typography>
            <Typography variant="h5" component="div" sx={{fontSize:'17px'}}>
            <strong>Description:</strong>
      </Typography>
      <Typography variant="body1" gutterBottom>
        {produit.descri}
       
      </Typography>
      {avisList.length > 0 && (
  <List sx={{ width: '100%', maxWidth: 700, height: '500px', overflowY: 'auto', bgcolor: 'background.paper', padding: '10px' }}>
    <Typography gutterBottom variant="subtitle2" component="div" sx={{ fontSize: '15px' }}>
      Commentaire recu sur ce produit
    </Typography>
    {avisList.map((avis) => (
            <React.Fragment key={avis.id.idCli}>
                <ListItem alignItems="flex-start">
                    <ListItemAvatar>
                        <Avatar alt="Client" src="/static/images/avatar/1.jpg" />
                    </ListItemAvatar>
                    <ListItemText
                        primary={avis.avisCli.pseudo || 'Anonyme'}
                        secondary={
                            <React.Fragment>
                                {` — ${avis.commentaire}`}
                            </React.Fragment>
                        }
                    />
                </ListItem>
                <Divider variant="inset" component="li" />
            </React.Fragment>
          ))}
          </List>
        )}

            </Stack>
        </Stack>
        
        <SuppForm open={openDel} onClose={handleClose} idProduit={idPro}/>
        <ModifForm open={openMod} onClose={handleModifClose} produit={produit} idPro={idPro} />

        </>
    )
}
export default Detail;
 /* <div className="englobe">
   
<div className="cotegauche">
<h3 className="tfiltre">Filtrer la liste </h3>
<div className='filt'>
<Typography variant="p" component="div">
  Plus recent
</Typography>
</div>
<div className='filt'>
<Typography variant="p" component="div">
  Ordre croissant (A-Z)
</Typography>
</div>
<div className='filt'>
<Typography variant="p" component="div">
  Ordre decroissant (Z-A)
</Typography>
</div>
<div className='filt'>
<p>Selon les prix</p>
<div className="delprix">
  <input type="number" className="minprix" width='80px'/><label htmlFor="">min</label>
  <input type="number" className="maxprix" width='80px'/><label htmlFor="">max</label>

</div>
</div>
<div className='filt'>
<p>Selon les dates d'ajout</p>
<div className="deldate">
  <input type="date" className="debdate" width='80px'/><label htmlFor="">debut</label><br />
  <input type="date" className="findate" width='80px'/><label htmlFor="">fin</label>

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
          <Typography variant="h5" component="div">
  Produits mise en marche
</Typography>
          <Button variant="contained" startIcon={<AddCircleIcon />} onClick={handleClickOpen} sx={{marginLeft:"100px",backgroundColor:'#fdaf19'}}>
        Ajouter
      </Button>
      </Stack>
      <Stack spacing={2} sx={{marginTop:'25px',width:'100%'}}>
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    <FrCardVert />
    
    </Stack>
    <Box sx={{padding:'10px', marginTop:'50px',width:'100%', justifyContent:'center', alignItems:'center'}}>
    <Stack spacing={2} direction='row'>
  <Typography>Page: {page}</Typography>
  <Pagination count={10} page={page} onChange={handleChange} color='secondary' />
</Stack>
    </Box>
    </Container>
    <AddForm open={open} onClose={handleClose} />
    </div>
   
</div>*/