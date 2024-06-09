import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import Slide from '@mui/material/Slide';
import WarningIcon from '@mui/icons-material/Warning';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Transition = React.forwardRef(function Transition(props, ref) {
  return <Slide direction="up" ref={ref} {...props} />;
});

export default function SuppFrForm ({ open, onClose }){
  const history = useHistory();

  const delFournisseur = async () =>{
    const idFr= localStorage.getItem('fournisseurId')
    if (idFr) {
      try {
        const response = await axios.get(`http://localhost:8092/frDelete/${idFr}`);
         history('/');
      } catch (error) {
        console.error('Erreur de suppression:', error);
      }
    }

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
        <DialogTitle>{"Supprimer votre compte"}</DialogTitle>
        <DialogContent sx={{display:'flex', flexDirection:'column',alignItems:'center'}}>
        <WarningIcon sx={{ color: '#FF8E53', fontSize:'70px', margin:'10px' }} /> 
          <DialogContentText id="alert-dialog-slide-description">
          
            Voulez-vous vraiment supprimer votre compte? Apres avoir cliqué sur 'Supprimer', vous n'aurez plus accès à ce compte et vos produits seront retirés du marché.
          </DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={onClose} sx={{color:'#1d1a35'}}>Annuler</Button>
          <Button onClick={delFournisseur} sx={{color:'#FF8E53', border:'1px solid #FF8E53'}}>Supprimer</Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
    )
}