import * as React from 'react';
import {useState, useEffect} from 'react';
import axios from 'axios';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import FormLabel from '@mui/material/FormLabel';
import FormControl from '@mui/material/FormControl';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormHelperText from '@mui/material/FormHelperText';
import Checkbox from '@mui/material/Checkbox';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import InputLabel from '@mui/material/InputLabel';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import AddCircleIcon from '@mui/icons-material/AddCircle';
import { Typography } from '@mui/material';

export default function ModifForm({ open, onClose, produit, idPro }) {
   const [design, setDesign] = useState('');
  const [prix, setPrix] = useState('');
  const [descri, setDescri] = useState('');
  const [qte, setQte] = useState('');
  const [imgProd, setImgProd] = useState('');
  const [categorie, setCategorie] = useState('');
  const [date, setDate] = useState(new Date().toISOString());
  
  /*console.log("produit.design :", produit.design);
  console.log("produit.design :", produit.prix);
  console.log("produit.design :", qte);*/
    const categories = ['Categorie 1', 'Categorie 2', 'Categorie 3']; 
  
     useEffect(() => {
    if (produit) {
      setDesign(produit.design);
      setPrix(produit.prix);
      setDescri(produit.descri);
      setQte(produit.qte);
      setCategorie(produit.categorie);
    }
  }, [produit]);
    const handleImgChange = (event) => {
      setImgProd(event.target.files[0]); 
    };
  
    const handleSubmit = async (event) => {
      event.preventDefault();

      const currentDate = new Date().toISOString();
      
     
    /*    const formData = new FormData();
    formData.append('imgFile', imgProd);
    formData.append('design', design);
    formData.append('categorie', categorie);
    formData.append('prix', prix);
    formData.append('qte', qte);
    formData.append('descri', descri); */
    const data = { design, categorie, prix, qte, descri };
    try {
       await axios.put(`http://localhost:8092/Produits/produitPut/${idPro}`,{
        design,
        categorie,
        prix,
        qte,
        descri
      });
      console.log('Produit mis à jour avec succès:');
    } catch (error) {
      console.error('Erreur lors de la modification du produit', error);
      return;
    }
  
    // PUT request to update imgPro if a new image is uploaded
    if (imgProd) {
      const formData = new FormData();
      formData.append('imgFile', imgProd);
  
      try {
        const response = await axios.put(`http://localhost:8092/Produits/produitPutImg/${idPro}`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        });
        console.log('Product image updated successfully:', response.data);
      } catch (error) {
        console.error('Error updating product image:', error);
      }
    }
    onClose();
        // PUT requete pour modifier le produit
        console.log('Form submitted with multipart 2:', { design, prix, descri, qte, imgProd, categorie,idPro });
      
    };
    return (
      <React.Fragment>
        <Dialog open={open} onClose={onClose}>
          <DialogTitle>Modifier le produit</DialogTitle>
          <DialogContent sx={{ display: 'flex', gap: '16px' }}>
        {/* Image Preview */}
        <div style={{ width: '50%', textAlign: 'center' }}>
                {imgProd ? (
                    // Si image uploadée, on l'affiche
                    <img
                      src={URL.createObjectURL(imgProd)}
                      alt="Product Preview"
                      style={{ maxWidth: '100%', height: 'auto', borderRadius: '8px' }}
                    />
                  ) : (
                    // Si aucun image uploadé, on affiche le contenu de imgPro
                    <img
                      src={`data:image/jpeg;base64,${produit.imgPro}`}
                      alt="Product Preview"
                      style={{ maxWidth: '100%', height: 'auto', borderRadius: '8px' }}
                    />
                  )}
        </div>
        {/* Form Fields */}
        <div style={{ width: '50%' }}>
            <DialogContentText>
              Vous pouvez modifier ici les informations de votre produit
            </DialogContentText>
            <input
          accept="image/*"
          id="imgProd"
          type="file"
          onChange={handleImgChange}
          style={{ display: 'none' }}
        />
            <label htmlFor="imgProd">
            Ajouter une image <br />
            <Button variant="outlined" component="span" sx={{marginTop:"5px", color:"orange", borderColor:"orange"}}>
              Upload
            </Button>
            <Typography>
            {imgProd && <span>{imgProd.name}</span>}
            </Typography>
          </label>
            <TextField
              autoFocus
              margin="dense"
              id="design"
              label="Nom du produit"
              type="text"
              fullWidth
              variant="standard"
              value={design}
              onChange={(e) => setDesign(event.target.value)}
            />
            {/*<FormControl fullWidth margin="dense">
              <InputLabel id="cat-label">Catégorie</InputLabel>
              <Select
                labelId="cat-label"
                id="cat"
                value={cat}
                label="Catégorie"
                onChange={handleCatChange}
              >
               {categories.map((category) => (
                <MenuItem key={category} value={category}>
                  {category}
                </MenuItem>
              ))}
            </Select>
               </FormControl>*/}
                <TextField
              margin="dense"
              id="cat"
                value={categorie}
                label="Catégorie"
                onChange={(e) => setCategorie(e.target.value)}
              fullWidth
              variant="standard"
             
            />
            <TextField
              margin="dense"
              id="prix"
              label="Prix"
              type="number"
              fullWidth
              variant="standard"
              value={prix}
              onChange={(e) => setPrix(e.target.value)}
            />
            
            <TextField
              margin="dense"
              id="qte"
              label="Quantité en stock"
              type="number"
              fullWidth
              variant="standard"
              value={qte}
              onChange={(e) => setQte(e.target.value)}
            />
            
         
          <TextField
              margin="dense"
              id="descr"
              label="Description"
              multiline
              rows={4}
              fullWidth
              variant="standard"
              value={descri}
              onChange={(e) => setDescri(e.target.value)}
            />
            </div>
        </DialogContent>
        <DialogActions>
          <Button onClick={onClose} sx={{color:"grey"}}>Annuler</Button>
          <Button type="submit" variant="contained" onClick={handleSubmit} 
          sx={{backgroundColor:'#ffad64',
          '&:hover': {
    backgroundColor: 'white',
    color:'#ffad64',
  },}}>
            Valider
          </Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
  );
}
