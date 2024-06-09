import * as React from 'react';
import { useNavigate } from 'react-router-dom';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Slide from '@mui/material/Slide';
import WarningIcon from '@mui/icons-material/Warning';
import axios from 'axios';

const Transition = React.forwardRef(function Transition(props, ref) {
  return <Slide direction="up" ref={ref} {...props} />;
});

export default function SuppForm ({ open, onClose, idProduit }){
  const history = useNavigate(); 
  const delProduit = async () =>{
  
    
    if (idProduit) {
      try {
        const response = await axios.delete(`http://localhost:8092/Produits/produitDelete/${idProduit}`);
         console.log(response.data);
      } catch (error) {
        console.error('Erreur de suppression:', error);
      }
    }
    history('/fournisseur');
  }
    return (
        <React.Fragment>
        <Dialog
        open={open}
        TransitionComponent={Transition}
        keepMounted
        onClose={onClose}
        aria-describedby="alert-dialog-slide-description"
      >
        <DialogTitle>{"Retirer le produit"}</DialogTitle>
        <DialogContent sx={{display:'flex', flexDirection:'column',alignItems:'center'}}>
        <WarningIcon sx={{ color: '#FF8E53', fontSize:'70px', margin:'10px' }} /> 
          <DialogContentText id="alert-dialog-slide-description">
            Voulez-vous vraiment supprimer ce produit du marche? Apres avoir clique sur 'Supprimer', le client ne pourra plus voir ce produit.
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={onClose} sx={{color:'#1d1a35'}}>Annuler</Button>
          <Button onClick={delProduit} sx={{color:'#FF8E53', border:'1px solid #FF8E53'}}>Supprimer</Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
    )
}
