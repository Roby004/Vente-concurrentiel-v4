import * as React from 'react';
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
export default function AddForm({ open, onClose }) {
    const [design, setDesign] = React.useState(''); // State for design input
    const [prix, setPrix] = React.useState(''); // State for prix input
    const [descr, setDescr] = React.useState(''); // State for descr input
    const [qte, setQte] = React.useState(''); // State for qte input
    const [imgProd, setImgProd] = React.useState(''); // State for imgProd input (assuming a URL)
    const [cat, setCat] = React.useState(''); // State for cat selection
  
    const categories = ['Categorie 1', 'Categorie 2', 'Categorie 3']; // Replace with your actual categories
  
  
    const handleImgChange = (event) => {
      setImgProd(event.target.files[0]); 
    };
  
    
  
    const handleSubmit = async () => {
      event.preventDefault();
  
      /*const formData = new FormData();
      formData.append('file', imgProd);
      formData.append('design', design);
      formData.append('prix', prix);
      formData.append('descr', descr);
      formData.append('qte', qte);
      formData.append('cat', cat);
      
      console.log('Form submitted:', { design, prix, descr, qte, imgProd, cat });
      // PUT requete pour modifier le produit
      const response = await axios.post('http://localhost:8080/"/produitsPost', formData, {
        headers: {
          'Content-Type': 'multipart/form-data' // Set Content-Type header to multipart/form-data for file upload
        }
      });*/
      const fournisseurId = localStorage.getItem('fournisseurId');
       const formData = new FormData();
    formData.append('imgFile', imgProd);
    formData.append('design', design);
    formData.append('categorie', cat);
    formData.append('prix', prix);
    formData.append('qte', qte);
    formData.append('descri', descr);
     // Add supplier ID here
    console.log('Form submitted with multipart 2:', { design, prix, descr, qte, imgProd, cat,fournisseurId });
    if(fournisseurId){
      try {
        const response = await axios.post(`http://localhost:8092/Produits/addProduit/${fournisseurId}`, formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
        console.log('Ajout du produit réussi :', response.data);
      } catch (error) {
        console.error('Error:', error);
      }
    }
    
   
      onClose(); // Close the modal after submission
    };
  
    return (
      <React.Fragment>
        <Dialog open={open} onClose={onClose}>
          <DialogTitle>Ajouter un nouveau produit</DialogTitle>
          <DialogContent>
            <DialogContentText>
              Veuillez saisir les informations du nouveau produit.
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
            <Button variant="outlined" component="span" sx={{color:"orange", borderColor:"orange"}}>
              Upload
            </Button>
            {imgProd && <span>{imgProd.name}</span>}
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
                value={cat}
                label="Catégorie"
                onChange={(e) => setCat(e.target.value)}
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
              value={descr}
              onChange={(e) => setDescr(e.target.value)}
            />
        </DialogContent>
        <DialogActions>
          <Button onClick={onClose}>Annuler</Button>
          <Button type="submit" variant="contained" onClick={handleSubmit} sx={{backgroundColor:'#ffad64'}}>
            Ajouter
          </Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
  );
}
{/*const AddForm = ({ open, onClose }) => {
    return (
      <React.Fragment>
        <Dialog
          open={open}
          onClose={handleClose}
          PaperProps={{
            component: 'form',
            onSubmit: (event) => {
              event.preventDefault();
              const formData = new FormData(event.currentTarget);
              const formJson = Object.fromEntries(formData.entries());
              const email = formJson.email;
              console.log(email);
              handleClose();
            },
          }}
        >
          <DialogTitle>Ajouter Nouveau produit</DialogTitle>
          <DialogContent>
            <DialogContentText>
            </DialogContentText>
            <TextField
              autoFocus
              required
              margin="dense"
              id="name"
              name="design"
              label="Nom du produit"
              type="text"
              fullWidth
              variant="standard"
            />
            <TextField
              autoFocus
              required
              margin="dense"
              id="name"
              name=""
              label="Email Address"
              type="email"
              fullWidth
              variant="standard"
            />
            <TextField
              autoFocus
              required
              margin="dense"
              id="name"
              name="email"
              label="Email Address"
              type="email"
              fullWidth
              variant="standard"
            />
            <TextField
              autoFocus
              required
              margin="dense"
              id="name"
              name="email"
              label="Email Address"
              type="email"
              fullWidth
              variant="standard"
            />
            <TextField
              autoFocus
              required
              margin="dense"
              id="name"
              name="email"
              label="Email Address"
              type="email"
              fullWidth
              variant="standard"
            />
          </DialogContent>
          <DialogActions>
            <Button onClick={handleClose}>Cancel</Button>
            <Button type="submit">Subscribe</Button>
          </DialogActions>
        </Dialog>
      </React.Fragment>
    );
  }

export default AddForm;*/}
{/*const AddForm = () =>{
    return(
        <>
        <Container>
            <h3>Ajouter nouveau produit</h3>
            <FormGroup>
                <FormControl>
                    <InputLabel>Nom du produit</InputLabel>
                    <Input/>
                </FormControl>
            </FormGroup>
        </Container>
        </>
    )

}
export default AddForm;*/}